package kr.watchu.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String form() {
		return "userWrite";
	}
	
	//�α��� �� ȣ��
}
