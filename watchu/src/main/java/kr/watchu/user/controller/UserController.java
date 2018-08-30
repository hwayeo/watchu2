package kr.watchu.user.controller;


import java.util.List;


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

import org.springframework.web.servlet.ModelAndView;

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
		
		return "redirect:/main/main.do";
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
		
		return "redirect:/user/userMypage.do";
		
	}
	
	//==========================================ȸ������========================================
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/deleteUser.do",method=RequestMethod.GET)
	public String deleteForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = new UserCommand();
		user.setId(id);
		
		model.addAttribute("command",user);
		
		return "userDelete";
	}
	//ȸ�������� ����
	@RequestMapping(value="/user/deleteUser.do",method=RequestMethod.POST)
	public String deleteSubmit(@ModelAttribute("command") @Valid UserCommand userCommand,BindingResult result,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>>:"+ userCommand);
		}
		
		/*userService.deleteUser(userCommand.getId());
		//�α׾ƿ�
		session.invalidate();
		return "redirect:/main/main.do";*/
		//passwd �ʵ��� ������ üũ
		if(result.hasFieldErrors("passwd")) {
			return "userDelete";
		}
		
		//��й�ȣ ��ġ ���� üũ
				try {
					UserCommand user = userService.selectUser(userCommand.getId());
					boolean check = false;
					
					if(user!=null) {
						//��й�ȣ ��ġ ���� üũ
						check = user.isCheckedPasswd(cipherAES.encrypt(userCommand.getPasswd()));
					}
					if(check) {
						//��������, ȸ������ ����
						userService.deleteUser(userCommand.getId());
						//�α׾ƿ�
						session.invalidate();
						return "redirect:/main/main.do";
					}else {
						//��������
						throw new Exception();
					}
				
				}catch(Exception e) {
					result.rejectValue("passwd", "invalidPassword");
					return "userDelete";
				}
	}
	
	//==========================================��õģ�����(ȸ����ü ���)========================================
	@RequestMapping("/user/following.do")
	public ModelAndView follow() {		
		
		List<UserCommand> list = null;
		
		list = userService.selectfollowList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userfollowing");
		mav.addObject("list",list);
		
		return mav;
	}
	
	// Ÿ�Ӷ���
	@RequestMapping("/user/userTimeline.do")
	public String timeline() {
		return "userTimeline";
	}
	
}
