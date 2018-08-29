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
	
	//�α�
	private Logger log = Logger.getLogger(this.getClass());

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
		
		model.addAttribute("user", user);
		
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
	
	//��Ϲ���(�������â)
	@RequestMapping("/user/setup.do")
	public String setup() {
		return "user/userSetup";
	}
	
	
	//�ȷ���
	@RequestMapping("/user/following.do")
	public String follow() {
		return "userfollowing";
	}
}
