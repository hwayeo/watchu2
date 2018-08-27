package kr.watchu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	//==========��ȭ ����==========//
	//��ȭ ���
	@RequestMapping("/admin/admin_movieList.do")
	public String process() {

		return "admin_movieList";
	}
	//��ȭ ������ ���
	@RequestMapping("/admin/officialList.do")
	public String process2() {
		
		return "officialList";
	}
	//��ȭ �帣 ���
	@RequestMapping("/admin/genreList.do")
	public String genre() {
		
		return "genreList";
	}
	//��ȭ ���� ����
	@RequestMapping("/admin/movieRating.do")
	public String process3() {
		
		return "movieRating";
	}
	
	//==========ȸ�� ����==========//
	//ȸ�����
	@RequestMapping("/admin/userList.do")
	public String process4() {
		
		return "userList";
	}
	//�Ű�ȸ��
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {
		
		return "reportedUser";
	}
	
	//==========�� ����==========//
	//�� ����
	@RequestMapping("/admin/support.do")
	public String process6() {
		
		return "support";
	}
}
