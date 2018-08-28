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
	@RequestMapping("/user/mypage_movie.do")
	public String mypage_movie() {
		return "userMypage_movie";
	}
	
	//���� ��ȭ ��� ������
	@RequestMapping("/user/mypage_movielist.do")
	public String mypage_movielist() {
		return "userMypage_movielist";
	}
	
	//�ڸ�Ʈ
	@RequestMapping("/user/comment.do")
	public String comment() {
		return "userComment";
	}
	
	//�ڸ�Ʈ ��������
	@RequestMapping("/user/comment_detail.do")
	public String comment_detail() {
		return "userComment_detail";
	}
		
}
