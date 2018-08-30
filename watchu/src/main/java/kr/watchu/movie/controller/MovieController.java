package kr.watchu.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	//===영화 메인 목록===//
	@RequestMapping("/movie/movieHome.do")
	public String movieHome() {
		return "movieHome";
	}
	
	@RequestMapping("/movie/movieList.do")
	public String movieList(){
		return "movieList";
	}
	
	@RequestMapping("/movie/movieEva.do")
	public String movieEva() {
		return "movieEva";
	}
}
