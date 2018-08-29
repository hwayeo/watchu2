package kr.watchu.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/user/userMypage.do")
	public String mypage(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + user);
		}
		
		model.addAttribute("user", user);
		
		return "userMypage";
	}
	
	//평가한 영화 목록
	@RequestMapping("/user/userMypage_movie.do")
	public String mypage_movie() {
		return "userMypage_movie";
	}
	
	//평가한 영화 목록 더보기
	@RequestMapping("/user/userMypage_movielist.do")
	public String mypage_movielist() {
		return "userMypage_movielist";
	}
	
	//코멘트
	@RequestMapping("/user/userComment.do")
	public String comment(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + user);
		}
		
		model.addAttribute("user", user);
		
		return "userComment";
	}
	
	//코멘트 상세페이지
	@RequestMapping("/user/userComment_detail.do")
	public String comment_detail(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + user);
		}
		
		model.addAttribute("user", user);
		
		return "userComment_detail";
	}
	
	//좋아요한 코멘트
	@RequestMapping("/user/userLikeComment.do")
	public String likeComment() {
		return "userLikeComment";
	}
	
	//보고싶어요
	@RequestMapping("/user/userWish.do")
	public String wish() {
		return "userWish";
	}
	
	//보는중
	@RequestMapping("/user/userWatching.do")
	public String watching() {
		return "userWatching";
	}
	
	//톱니바퀴(설정모달창)
	@RequestMapping("/user/setup.do")
	public String setup() {
		return "user/userSetup";
	}
	
	
	//팔로잉
	@RequestMapping("/user/following.do")
	public String follow() {
		return "userfollowing";
	}
}
