package kr.watchu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	//==========영화 관리==========//
	//영화 목록
	@RequestMapping("/admin/admin_movieList.do")
	public String process() {

		return "admin_movieList";
	}
	//영화 관계자 목록
	@RequestMapping("/admin/officialList.do")
	public String process2() {
		
		return "officialList";
	}
	//영화 장르 목록
	@RequestMapping("/admin/genreList.do")
	public String genre() {
		
		return "genreList";
	}
	//영화 별점 관리
	@RequestMapping("/admin/movieRating.do")
	public String process3() {
		
		return "movieRating";
	}
	
	//==========회원 관리==========//
	//회원목록
	@RequestMapping("/admin/userList.do")
	public String process4() {
		
		return "userList";
	}
	//신고회원
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {
		
		return "reportedUser";
	}
	
	//==========고객 지원==========//
	//고객 문의
	@RequestMapping("/admin/support.do")
	public String process6() {
		
		return "support";
	}
}
