package kr.watchu.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main/main.do")
	public String process() {

		return "main";
	}
}
