package kr.watchu.movie.controller;

import java.util.ArrayList;
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
import kr.watchu.user.controller.userConfirmIdAjaxController;
import kr.watchu.user.service.UserService;
import kr.watchu.util.PagingUtil;
import kr.watchu.util.StringUtil;

@Controller
public class MovieViewController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MovieService movieService;
	@Resource
	private CommentService commentService;
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("commentCommand")
	public CommentCommand initCommentCommand() {
		return new CommentCommand();
	}

	//�� �� �����
	@RequestMapping("/movie/movieDetail.do")
	public ModelAndView movieDetail(@RequestParam("movie_num") Integer movie_num, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		//��ȭ �⺻ ����
		MovieCommand movie = movieService.selectMovie(movie_num);

		List<CommentCommand> commentList = new ArrayList<CommentCommand>();

		commentList = commentService.selectCommentList(movie_num);

		int commentCnt = commentService.selectCommentCnt(movie_num);

		mav.setViewName("movieDetail");
		//�ش� ��ȭ�� �ۼ��� ����� �ִ��� Ȯ��
		String id = (String)session.getAttribute("user_id");
		
		if(id!=null) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", id);
			map.put("movie_num", movie_num);
			CommentCommand comment = commentService.selectComment(map);
			
			if(log.isDebugEnabled()){
				log.debug("<<id>> : " + id);
				log.debug("<<movie_num>> : " + movie_num);
				log.debug("<<comment>> : " + comment);
			}
			if(comment!=null) {
				mav.addObject("comment",comment);
			}else {
				mav.addObject("comment",null);
			}
		}
		mav.addObject("movie",movie);
		mav.addObject("commentList",commentList);
		mav.addObject("commentCnt",commentCnt);

		return mav;

	}
	//�ڸ�Ʈ ��� �� 
	@RequestMapping(value="/movie/commentWrite.do",method=RequestMethod.GET)
	public String commentForm() {
		return "movieDetail";
	}
	//�ڸ�Ʈ ������ ���� 
	@RequestMapping(value="/movie/commentWrite.do",method=RequestMethod.POST)
	public String insertComment(@ModelAttribute("comentCommand") @Valid CommentCommand commentCommand, BindingResult result, HttpSession session) {

		if(log.isDebugEnabled()) {
			log.debug("<<commentCommand>> : "+commentCommand);
		}
		if(result.hasErrors()) {
			return commentForm();
		}

		String id = (String)session.getAttribute("user_id");

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("movie_num", commentCommand.getMovie_num());

		CommentCommand comment = commentService.selectComment(map);
		if(comment!=null) {
			return "redirect:/movie/movieDetail.do?movie_num="+commentCommand.getMovie_num();
		}else {
			commentService.insertComment(commentCommand);
		}
		return "redirect:/movie/movieDetail.do?movie_num="+commentCommand.getMovie_num();
	}
	//==================================�ڸ�Ʈ ����=============================
	
	//�ڸ�Ʈ���� ������ ����
	@RequestMapping(value="/movie/updateCommentWrite.do",method=RequestMethod.POST)
	public String updateComment(@ModelAttribute("commentCommand") @Valid CommentCommand commentCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<commentCommand>> :" + commentCommand);
		}
		if(result.hasErrors()) {
			return "redirect:/movie/movieDetail.do?movie_num="+commentCommand.getMovie_num();
		}
		
		commentService.updateComment(commentCommand);
		
		return "redirect:/movie/movieDetail.do?movie_num="+commentCommand.getMovie_num();
		}
	
	//ȸ�� ������ ���� 
	@RequestMapping("/movie/deleteComment.do")
	public String deleteComment(@RequestParam("comment_num") Integer comment_num, 
			 					@RequestParam("movie_num") Integer movie_num) {
		
		
		commentService.deleteComment(comment_num);
		
		return "redirect:/movie/movieDetail.do?movie_num="+movie_num;
	}
}
