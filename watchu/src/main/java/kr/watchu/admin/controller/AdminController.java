package kr.watchu.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.watchu.movie.domain.GenreCommand;
import kr.watchu.movie.service.GenreService;

@Controller
public class AdminController {
	//�α� ����
	private Logger log = Logger.getLogger(this.getClass());
	  
	//�ڿ� ���� ����	
	@Resource
	private GenreService genreService;
	
	@ModelAttribute("command")
	public GenreCommand initCommand() {
		return new GenreCommand();
	}
	
	//==========��ȭ ����_��ȭ���==========//
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
	
	//==========��ȭ ����_��ȭ �帣==========//
	//��� �� ȣ��
	@RequestMapping("/admin/genreList.do")
	public String genre_form() {
		
		return "genreList";
	}
	//���۵� ������ ó��
	@RequestMapping(value="/admin/genreList.do", method=RequestMethod.POST)
	public String genre_submit(@ModelAttribute("command") @Valid GenreCommand genreCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<genreCommand>>: " + genreCommand);
		}
		
		genreService.insertGenre(genreCommand);
		
		return "redirect:/admin/genreList.do";
	}
	
	//==========��ȭ ����_��ȭ ����==========//
	@RequestMapping("/admin/movieRating.do")
	public String process3() {
		
		return "movieRating";
	}
	
	//==========ȸ�� ����_ȸ�� ���==========//
	@RequestMapping("/admin/userList.do")
	public String process4() {
		
		return "userList";
	}

	//==========ȸ�� ����_�Ű� ȸ��==========//
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {
		
		return "reportedUser";
	}
	
	//==========�� ����_�� ����==========//
	@RequestMapping("/admin/support.do")
	public String process6() {
		
		return "support";
	}
}
