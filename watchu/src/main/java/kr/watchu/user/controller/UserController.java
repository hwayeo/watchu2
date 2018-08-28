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
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	//==========================================ȸ������========================================
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String insertForm() {
		return "userWrite";
	}
	//ȸ������ ������ ����
	@RequestMapping(value="/user/write.do",method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : "+userCommand);
		}
		
		if(result.hasErrors()) {
			return insertForm();
		}
		//��ȣȭ ó��
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		userService.insertUser(userCommand);
		
	    //===ȸ������ ������ �ٷ� �α��� ó��===///
		session.setAttribute("user_id", userCommand.getId());
		//ȸ�����Խ� �ʱ� auth �� 1�� ������ش�
		session.setAttribute("user_auth", 1);
		
		return "userWrite2";
	}
	//==========================================ȸ������========================================
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.GET)
	public String modifyForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = userService.selectUser(id);
		model.addAttribute("command",user);
		
		return "userModify";
	}
	//ȸ������ ������ ����
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> :" + userCommand);
		}
		if(result.hasErrors()) {
			return "userModify";
		}
		
		//��ȣȭ ó��
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		//ȸ����������
		userService.updateUser(userCommand);
		
		return "redirect:/user/mypage.do";
		
	}
	
	
}
