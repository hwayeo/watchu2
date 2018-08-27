package kr.watchu.main.controller;

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
public class MainController {

	@Resource
	private UserService userService;

	//자바빈 초기화
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	@RequestMapping("/main/main.do")
	public String process() {

		return "main";
	}

	//로그인
	@RequestMapping(value="/main/login.do",method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result, HttpSession session) {

		return "redirect:/main/main.do";
	}
}
