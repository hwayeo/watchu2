package kr.watchu.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	
	@RequestMapping("/movie/list.do")
	public String movielist() {
		return "movieList";
	}
}
