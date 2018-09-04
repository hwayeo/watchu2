package kr.watchu.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.service.CommentService;
import kr.watchu.movie.service.MovieService;
import kr.watchu.util.PagingUtil;
import kr.watchu.util.StringUtil;

@Controller
public class MovieViewController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MovieService movieService;
	@Resource
	private CommentService commentService;
	//자바빈 초기화
	@ModelAttribute("commentCommand")
	public CommentCommand initCommentCommand() {
		return new CommentCommand();
	}
	
	//글 상세 보기용
	@RequestMapping("/movie/movieDetail.do")
	public ModelAndView movieDetail(@RequestParam("movie_num") int movie_num) {
		
		if(log.isDebugEnabled()){
			log.debug("<<movie_num>> : " + movie_num);
		}
		
		MovieCommand movie = movieService.selectMovie(movie_num);
		
		return new ModelAndView("movieDetail","movie",movie);
		
		
	}
	//코멘트 등록 폼 
	@RequestMapping(value="/movie/commentWrite.do",method=RequestMethod.GET)
		public String commentForm() {
		return "movieDetail";
	}
	//코멘트 데이터 전송 
	@RequestMapping(value="/movie/commentWrite.do",method=RequestMethod.POST)
		public String insertComment(@ModelAttribute("comentCommand") @Valid CommentCommand commentCommand, BindingResult result, HttpSession session) {
			
			if(log.isDebugEnabled()) {
				log.debug("<<commentCommand>> : "+commentCommand);
			}
			if(result.hasErrors()) {
				return commentForm();
			}
			commentService.insertComment(commentCommand);
			
			return "redirect:/movie/movieDetail.do?movie_num="+commentCommand.getMovie_num();
	}
}
