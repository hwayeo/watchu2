package kr.watchu.user.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;
import kr.watchu.util.PagingUtil;
import kr.watchu.util.SplitUtil;

@Controller
public class MyPageController {
	
	//로그
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
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
		
		//팔로잉 숫자 표시하기위해 친구 arraylist만듬
		List<String> follow_id3 = new ArrayList<String>();
		
		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//쉼표제거
		
			//for문 돌려서 String배열요소 Array리스트에 넣기
			for(int i=0;i<follow_id2.length; i++) {
				follow_id3.add(follow_id2[i]);
			}
			
		}else {
			follow_id3.add(null);
		}
		
		model.addAttribute("user", user);
		model.addAttribute("list",follow_id3);
		
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
	public ModelAndView myfollowing(HttpSession session,@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			   											@RequestParam(value="keyfield",defaultValue="") String keyfield,
			   											@RequestParam(value="keyword",defaultValue="") String keyword) {		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//총글의 갯수 또는 검색된 글의 갯수
		int count = userService.selectUserCnt(map);
		if(log.isDebugEnabled()) {
			log.debug("<<count>>:" + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"myfollowing.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		//------------------------------------------------
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		ModelAndView mav = new ModelAndView();
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
		mav.addObject("follow",follow_id3);
		//끝
		
		//팔로우한 사람들의 command필요하므로 가입한 모든 사람 리스트목록 불러옴
		List<UserCommand> list = null;
		list = userService.selectUserList(map);
		//-------------------------------------------
		
		mav.setViewName("userFollowing");
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("pagingHtml",page.getPagingHtml());
		mav.addObject("user",user);

		

		return mav;
	}
	
	
	//언팔로우버튼 처리
	@RequestMapping("/user/unfollow.do")
	@ResponseBody
	public Map<String,String> unfollow(@RequestParam(value="unfollow_id") String unfollow_id,@RequestParam(value="user_id") String user_id){
		if(log.isDebugEnabled()) {
			log.debug("<<unfollow_id~~~>>:" + unfollow_id);
		}
		ModelAndView mav = new ModelAndView();
		UserCommand user = userService.selectUser(user_id);
		
		//시작
		List<String> follow_id3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//쉼표제거

			//for문 돌려서 String배열요소 Array리스트에 넣기
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
		mav.addObject("follow",follow_id3);
		//끝
		
		if(follow_id3.contains(unfollow_id)==true) {//언팔누르는 아이디가 내 친구목록에 있으면
			follow_id3.remove(unfollow_id);
			//로그확인
			if(log.isDebugEnabled()) {
				log.debug("<<☆★follow_id3~~~>>:" + follow_id3);
			}
		}
		
		//follow_id3요소들을 다시 쉽표붙여서 String에 넣기
		String followback = "";
		if(follow_id3.isEmpty()) {//마지막남은친구도 언팔하면..
			followback = "";
		}else {//두명 이상일때 언팔누르면
		
			for(int i=0; i<follow_id3.size(); i++) {
				followback += follow_id3.get(i) + "," ;
			}
			//마지막 쉼표는 제거해야댐
			followback = followback.substring(0,followback.length()-1);
		}
		if(log.isDebugEnabled()) {
			log.debug("<<☆★followback~~~>>:" + followback);
		}
		user.setFollow(followback);
		
		//언팔로우한 친구 빼고 db에 update
		userService.insertFollow(user);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
	
	
	
	
}
