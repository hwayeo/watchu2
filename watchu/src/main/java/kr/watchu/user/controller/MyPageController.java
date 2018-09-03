package kr.watchu.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;
import kr.watchu.util.SplitUtil;

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
	
	//댓글 쓰기
	@RequestMapping("/user/userCommentWrite.do")
	public String commentWrite() {
		return "user/userCommentWrite";
	}
	
	//톱니바퀴(설정모달창)
	@RequestMapping("/user/setup.do")
	public String setup() {
		return "user/userSetup";
	}
	
	//===============================내 팔로잉 목록 보기====================================
	//팔로잉목록
	@RequestMapping("/user/myfollowing.do")
	public String myfollowing(HttpSession session,Model model) {		
		
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		//시작(쉼표제거)
		List<String> follow_id3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//쉼표제거

			//for문 돌려서 배열요소 리스트에 넣기
			for(int i=0;i<follow_id2.length; i++) {
				follow_id3.add(follow_id2[i]);
			}

		}else {
			follow_id3.add(null);
		}
		//로그확인
		if(log.isDebugEnabled()) {
			log.debug("<<☆★follow_id3~~~>>:" + follow_id3);
		}
		model.addAttribute("follow",follow_id3);
		//끝
		
		//팔로우한 사람들의 command필요하므로 가입한 모든 사람 리스트목록 불러옴
		List<UserCommand> list = null;
		list = userService.selectfollowList();
		
		model.addAttribute("user", user);
		model.addAttribute("list", list);

		

		return "user/userFollowing";
	}
	//언팔로우버튼 처리
	
	
	
}
