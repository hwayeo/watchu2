package kr.watchu.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	//회원가입 폼 호출
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String form() {
		return "userWrite";
	}
	
	//로그인 폼 호출
}
