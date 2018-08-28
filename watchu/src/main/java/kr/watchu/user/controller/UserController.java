package kr.watchu.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;
import kr.watchu.util.CipherTemplate;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UserService userService;
	
	@Resource
	private CipherTemplate cipherAES;
	//자바빈 초기화
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	//==========================================회원가입========================================
	//회원가입 폼 호출
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String insertForm() {
		return "userWrite";
	}
	//회원가입 데이터 전송
	@RequestMapping(value="/user/write.do",method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : "+userCommand);
		}
		
		if(result.hasErrors()) {
			return insertForm();
		}
		//암호화 처리
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		userService.insertUser(userCommand);
		
	    //===회원가입 성공시 바로 로그인 처리===///
		session.setAttribute("user_id", userCommand.getId());
		//회원가입시 초기 auth 값 1을 등록해준다
		session.setAttribute("user_auth", 1);
		
		return "userWrite2";
	}
	//==========================================회원수정========================================
	//회원수정 폼 호출
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.GET)
	public String modifyForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = userService.selectUser(id);
		model.addAttribute("command",user);
		
		return "userModify";
	}
	//회원수정 데이터 전송
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> :" + userCommand);
		}
		if(result.hasErrors()) {
			return "userModify";
		}
		
		//암호화 처리
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		//회원정보수정
		userService.updateUser(userCommand);
		
		return "redirect:/user/mypage.do";
		
	}
	
	
}
