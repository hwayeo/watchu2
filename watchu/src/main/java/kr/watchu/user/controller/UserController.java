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
	
	//자바빈 초기화
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	
	//회원가입 폼 호출
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String form() {
		return "userWrite";
	}
}
