package kr.watchu.user.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.service.CommentService;
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
	@Resource
	private CommentService commentService;
	
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
		List<String> follow3 = new ArrayList<String>();
		
		if(user.getFollow() != null) {
			String follow = user.getFollow();
			String[] follow2 = SplitUtil.splitByComma(follow);//��ǥ����
		
			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<follow2.length; i++) {
				follow3.add(follow2[i]);
			}
			
		}else {
			follow3.clear();//null���� ���ֹ���
		}
		
		//�ȷο� ����
		List<String> follower3 = new ArrayList<String>();
		if(user.getFollower() != null) {
			String follower = user.getFollower();
			String[] follower2 = SplitUtil.splitByComma(follower);//��ǥ����
			
			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<follower2.length; i++) {
				follower3.add(follower2[i]);
			}
		}else {
			follower3.clear();
		}
		
		//�������
		List<String> blockList = new ArrayList<String>();
		if(user.getBlock() != null) {
			String block = user.getBlock();
			String[] block2 = SplitUtil.splitByComma(block);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<block2.length; i++) {
				blockList.add(block2[i]);
			}
		}else {
			blockList.clear();
		}
		
		model.addAttribute("user", user);
		model.addAttribute("list",follow3);
		model.addAttribute("list2",follower3);
		model.addAttribute("blockList",blockList);
				
				
		
		return "userMypage";
	}
	
	//���� ��ȭ ���
	@RequestMapping("/user/userMypage_movie.do")
	public String mypage_movie(@RequestParam(value="id") String id) {
		return "userMypage_movie";
	}
	
	//���� ��ȭ ��� ������
	@RequestMapping("/user/userMypage_movielist.do")
	public String mypage_movielist() {
		return "userMypage_movielist";
	}
	
	//�ڸ�Ʈ
	@RequestMapping("/user/userComment.do")
	public ModelAndView comment(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("user_id");
		
		if(log.isDebugEnabled()) {
			log.debug("<<user_id>> : "+id);
		}
		
		int count = commentService.selectMyCommentCnt(id);
		
		List<CommentCommand> list = null;
		if(count >0) {
			list = commentService.selectMyCommentList(id);
		}
		
		mav.setViewName("userComment");
		mav.addObject("commentList",list);
		mav.addObject("count",count);
		return mav;
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
	public String wish(@RequestParam(value="id") String id) {
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
	public ModelAndView myfollowing(HttpSession session,
									@RequestParam(value="id") String id,
			   					    @RequestParam(value="pageNum",defaultValue="1") int currentPage,
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
		String loginUserId = (String)session.getAttribute("user_id");
		
		UserCommand loginUser = userService.selectUser(loginUserId);//���� �α����� ���̵��� Ŀ�ǵ�
		UserCommand user = userService.selectUser(id);//get������� �Ѱܹ��� ���̵��� Ŀ�ǵ�
		ModelAndView mav = new ModelAndView();
		//����(��ǥ����)
		List<String> follow3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String follow1 = user.getFollow();
			String[] follow2 = SplitUtil.splitByComma(follow1);//��ǥ����

			//for�� ������ �迭��� ����Ʈ�� �ֱ�
			for(int i=0;i<follow2.length; i++) {
				follow3.add(follow2[i]);
			}

		}else {
			follow3.add(null);
		}
		
		mav.addObject("follow",follow3);
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
		mav.addObject("loginUser",loginUser);
		

		return mav;
	}
	
	//===============================�� �ȷο� ��� ����====================================
	//�ȷο����
	@RequestMapping("/user/myfollower.do")
	public ModelAndView myfollower(HttpSession session,
								   @RequestParam(value="id") String id,
			   				       @RequestParam(value="pageNum",defaultValue="1") int currentPage,
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
		String loginUserId = (String)session.getAttribute("user_id");
		
		UserCommand loginUser = userService.selectUser(loginUserId);//���� �α����� ���̵��� Ŀ�ǵ�
		UserCommand user = userService.selectUser(id);//get������� �Ѱܹ��� ���̵��� Ŀ�ǵ�	
		ModelAndView mav = new ModelAndView();
		//�� �ȷο� arrayList����
		List<String> follower3 = new ArrayList<String>();

		if(user.getFollower() != null) {
			String follower = user.getFollower();
			String[] follower2 = SplitUtil.splitByComma(follower);//��ǥ����

			//for�� ������ �迭��� ����Ʈ�� �ֱ�
			for(int i=0;i<follower2.length; i++) {
				follower3.add(follower2[i]);
			}

		}else {
			follower3.add(null);
		}
		mav.addObject("follower",follower3);
		//�� �ȷο� arrayList��
		
		//�� �ȷ��� arrayList ���� (�ȷ���,�ȷο���ư ��ġ ������ �ʿ���,c:if����üũ�Ϸ���)
		List<String> follow3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String follow1 = user.getFollow();
			String[] follow2 = SplitUtil.splitByComma(follow1);//��ǥ����

			//for�� ������ �迭��� ����Ʈ�� �ֱ�
			for(int i=0;i<follow2.length; i++) {
				follow3.add(follow2[i]);
			}

		}else {
			follow3.add(null);
		}

		mav.addObject("follow",follow3);
		//�� �ȷ��� arrayList ��
		
		

		//�ȷο� ������� command�ʿ��ϹǷ� ������ ��� ��� ����Ʈ��� �ҷ���
		List<UserCommand> list = null;
		list = userService.selectUserList(map);
		//-------------------------------------------

		mav.setViewName("userFollower");
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("pagingHtml",page.getPagingHtml());
		mav.addObject("user",user);
		mav.addObject("loginUser",loginUser);


		return mav;
	}
	
	//===============================�� ��� ��� ����====================================
		//�ȷ��׸��
		@RequestMapping("/user/myBlock.do")
		public ModelAndView myBlock(HttpSession session,
				   					    @RequestParam(value="pageNum",defaultValue="1") int currentPage,
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
			String user_id = (String)session.getAttribute("user_id");
			UserCommand user = userService.selectUser(user_id);//���� �α����� ���̵��� Ŀ�ǵ�
			
			ModelAndView mav = new ModelAndView();
			//�� Ŀ�ǵ忡 ��� ��ǥ���� arrayList�� �����
			List<String> blockList = new ArrayList<String>();
			if(user.getBlock() != null) {
				String block = user.getBlock();
				String[] block2 = SplitUtil.splitByComma(block);//��ǥ����

				//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
				for(int i=0;i<block2.length; i++) {
					blockList.add(block2[i]);
				}
			}else {
				blockList.clear();
			}
			
			//��
			
			//����� ������� command�ʿ��ϹǷ� ������ ��� ��� ����Ʈ��� �ҷ���
			List<UserCommand> list = null;
			list = userService.selectUserList(map);
			//-------------------------------------------
			
			mav.setViewName("userBlockList");
			mav.addObject("list",list);
			mav.addObject("count",count);
			mav.addObject("pagingHtml",page.getPagingHtml());
			mav.addObject("user",user);
			mav.addObject("blockList",blockList);

			return mav;
		}

}
