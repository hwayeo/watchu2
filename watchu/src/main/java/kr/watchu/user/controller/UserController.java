package kr.watchu.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String insertForm() {
		return "userWrite";
	}
	//ȸ������ ������ ����
	@RequestMapping(value="/user/write.do",method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("command") UserCommand user) {
		
		UserCommand userCommand = new UserCommand();
		//userCommand.setUpload(upload);
		userService.insertUser(user);
		
		return "user/userWrite2";
	}
	
	//�α���
	@RequestMapping(value="/user/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "";
	}

	@RequestMapping(value="/user/login.do",method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result, HttpSession session) {
		
		return "redirect:/main/main.do";
	}
}
