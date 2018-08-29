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
import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.domain.OfficialsCommand;
import kr.watchu.movie.service.GenreService;
import kr.watchu.movie.service.MovieService;
import kr.watchu.movie.service.OfficialsService;

@Controller
public class AdminController {
	//�α� ����
	private Logger log = Logger.getLogger(this.getClass());
	  
	//�ڿ� ���� ����	
	@Resource
	private GenreService genreService;
	@Resource
	private OfficialsService officialsService;
	@Resource
	private MovieService movieService;
	
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("movie_command")
	public MovieCommand initCommand3() {
		return new MovieCommand();
	}
	@ModelAttribute("official_command")
	public OfficialsCommand initCommand2() {
		return new OfficialsCommand();
	}
	@ModelAttribute("genre_command")
	public GenreCommand initCommand() {
		return new GenreCommand();
	}
	
	//==========��ȭ ����_��ȭ���==========//
	//��� �� ȣ��
	@RequestMapping("/admin/main.do")
	public String movie_form() {

		return "admin";
	} 
	//���۵� ������ ó��
	@RequestMapping(value="/admin/main.do", method=RequestMethod.POST)
	public String movie_submit(@ModelAttribute("movie_command") @Valid MovieCommand movieCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<MovieCommand>>: " + movieCommand);
		}
		
		movieService.insertMovie(movieCommand);
	
		return "redirect:/admin/main.do";
	}
	
	//==========��ȭ ����_��ȭ ������==========//
	//��� �� ȣ��
	@RequestMapping("/admin/officialList.do")
	public String official_form() {
			
			return "officialList";
	}
	//���۵� ������ ó��
	@RequestMapping(value="/admin/officialList.do", method=RequestMethod.POST)
	public String official_submit(@ModelAttribute("official_command") @Valid OfficialsCommand officialsCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<OfficialsCommand>>: " + officialsCommand);
		}
		
		officialsService.insert(officialsCommand);
		
		return "redirect:/admin/officialList.do";
	}
	
	//==========��ȭ ����_��ȭ �帣==========//
	//��� �� ȣ��
	@RequestMapping("/admin/genreList.do")
	public String genre_form() {
		
		return "genreList";
	}
	//���۵� ������ ó��
	@RequestMapping(value="/admin/genreList.do", method=RequestMethod.POST)
	public String genre_submit(@ModelAttribute("genre_command") @Valid GenreCommand genreCommand, BindingResult result, HttpServletRequest request) {
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
