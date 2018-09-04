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
	
	//�α�
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	@Resource
	private UserService userService;
	
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("userCommand")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	
	//���������� ����
	@RequestMapping("/user/userMypage.do")
	public String mypage(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + user);
		}
		
		//�ȷ��� ���� ǥ���ϱ����� ģ�� arraylist����
		List<String> follow_id3 = new ArrayList<String>();
		
		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//��ǥ����
		
			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
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
	
	//���� ��ȭ ���
	@RequestMapping("/user/userMypage_movie.do")
	public String mypage_movie() {
		return "userMypage_movie";
	}
	
	//���� ��ȭ ��� ������
	@RequestMapping("/user/userMypage_movielist.do")
	public String mypage_movielist() {
		return "userMypage_movielist";
	}
	
	//�ڸ�Ʈ
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
	
	//�ڸ�Ʈ ��������
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
	
	//���ƿ��� �ڸ�Ʈ
	@RequestMapping("/user/userLikeComment.do")
	public String likeComment() {
		return "userLikeComment";
	}
	
	//����;��
	@RequestMapping("/user/userWish.do")
	public String wish() {
		return "userWish";
	}
	
	//������
	@RequestMapping("/user/userWatching.do")
	public String watching() {
		return "userWatching";
	}
	
	//��� ����
	@RequestMapping("/user/userCommentWrite.do")
	public String commentWrite() {
		return "user/userCommentWrite";
	}
	
	//��Ϲ���(�������â)
	@RequestMapping("/user/setup.do")
	public String setup() {
		return "user/userSetup";
	}
	
	//===============================�� �ȷ��� ��� ����====================================
	//�ȷ��׸��
	@RequestMapping("/user/myfollowing.do")
	public ModelAndView myfollowing(HttpSession session,@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			   											@RequestParam(value="keyfield",defaultValue="") String keyfield,
			   											@RequestParam(value="keyword",defaultValue="") String keyword) {		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//�ѱ��� ���� �Ǵ� �˻��� ���� ����
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
		//����(��ǥ����)
		List<String> follow_id3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//��ǥ����

			//for�� ������ �迭��� ����Ʈ�� �ֱ�
			for(int i=0;i<follow_id2.length; i++) {
				follow_id3.add(follow_id2[i]);
			}

		}else {
			follow_id3.add(null);
		}
		//�α�Ȯ��
		if(log.isDebugEnabled()) {
			log.debug("<<�١�follow_id3~~~>>:" + follow_id3);
		}
		mav.addObject("follow",follow_id3);
		//��
		
		//�ȷο��� ������� command�ʿ��ϹǷ� ������ ��� ��� ����Ʈ��� �ҷ���
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
	
	
	//���ȷο��ư ó��
	@RequestMapping("/user/unfollow.do")
	@ResponseBody
	public Map<String,String> unfollow(@RequestParam(value="unfollow_id") String unfollow_id,@RequestParam(value="user_id") String user_id){
		if(log.isDebugEnabled()) {
			log.debug("<<unfollow_id~~~>>:" + unfollow_id);
		}
		ModelAndView mav = new ModelAndView();
		UserCommand user = userService.selectUser(user_id);
		
		//����
		List<String> follow_id3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<follow_id2.length; i++) {
				follow_id3.add(follow_id2[i]);
			}

		}else {
			follow_id3.add(null);
		}
		//�α�Ȯ��
		if(log.isDebugEnabled()) {
			log.debug("<<�١�follow_id3~~~>>:" + follow_id3);
		}
		mav.addObject("follow",follow_id3);
		//��
		
		if(follow_id3.contains(unfollow_id)==true) {//���ȴ����� ���̵� �� ģ����Ͽ� ������
			follow_id3.remove(unfollow_id);
			//�α�Ȯ��
			if(log.isDebugEnabled()) {
				log.debug("<<�١�follow_id3~~~>>:" + follow_id3);
			}
		}
		
		//follow_id3��ҵ��� �ٽ� ��ǥ�ٿ��� String�� �ֱ�
		String followback = "";
		if(follow_id3.isEmpty()) {//����������ģ���� �����ϸ�..
			followback = "";
		}else {//�θ� �̻��϶� ���ȴ�����
		
			for(int i=0; i<follow_id3.size(); i++) {
				followback += follow_id3.get(i) + "," ;
			}
			//������ ��ǥ�� �����ؾߴ�
			followback = followback.substring(0,followback.length()-1);
		}
		if(log.isDebugEnabled()) {
			log.debug("<<�١�followback~~~>>:" + followback);
		}
		user.setFollow(followback);
		
		//���ȷο��� ģ�� ���� db�� update
		userService.insertFollow(user);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
	
	
	
	
}
