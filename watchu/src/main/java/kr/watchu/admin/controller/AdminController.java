package kr.watchu.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.watchu.movie.domain.GenreCommand;
import kr.watchu.movie.service.GenreService;

@Controller
public class AdminController {
	//로그 설정
	private Logger log = Logger.getLogger(this.getClass());
	  
	//자원 주입 받음	
	@Resource
	private GenreService genreService;
	
	@ModelAttribute("command")
	public GenreCommand initCommand() {
		return new GenreCommand();
	}
	
	//==========영화 관리_영화목록==========//
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
	
	//==========영화 관리_영화 장르==========//
	//등록 폼 호출
	@RequestMapping("/admin/genreList.do")
	public String genre_form() {
		
		return "genreList";
	}
	//전송된 데이터 처리
	@RequestMapping(value="/admin/genreList.do", method=RequestMethod.POST)
	public String genre_submit(@ModelAttribute("command") @Valid GenreCommand genreCommand, BindingResult result, HttpServletRequest request) {
		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<genreCommand>>: " + genreCommand);
		}
		
		genreService.insertGenre(genreCommand);
		
		return "redirect:/admin/genreList.do";
	}
	
	//==========영화 관리_영화 별점==========//
	@RequestMapping("/admin/movieRating.do")
	public String process3() {
		
		return "movieRating";
	}
	
	//==========회원 관리_회원 목록==========//
	@RequestMapping("/admin/userList.do")
	public String process4() {
		
		return "userList";
	}

	//==========회원 관리_신고 회원==========//
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {
		
		return "reportedUser";
	}
	
	//==========고객 지원_고객 문의==========//
	@RequestMapping("/admin/support.do")
	public String process6() {
		
		return "support";
	}
}
