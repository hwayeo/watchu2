package kr.watchu.user.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;

@Controller
public class MyPageController {
	
	//로그
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private UserService userService;
	
	//자바빈 초기화
	@ModelAttribute("userCommand")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	
	//마이페이지 메인
	@RequestMapping("/user/mypage.do")
	public String mypage() {
		return "mypage";
	}
}
