package kr.watchu.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.movie.domain.GenreCommand;
import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.domain.OfficialsCommand;
import kr.watchu.movie.service.GenreService;
import kr.watchu.movie.service.MovieService;
import kr.watchu.movie.service.OfficialsService;
import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;
import kr.watchu.util.CipherTemplate;
import kr.watchu.util.PagingUtil;

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
	@Resource
	private UserService userService;
	@Resource
	private CipherTemplate cipherAES;

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
	@ModelAttribute("userCommand")
	public UserCommand initUserCommand() {
		return new UserCommand();
	}

	//����¡�� ���� ���� ����
	private int rowCount = 50;
	private int pageCount = 10;

	//==========������ �α���============//
	//�α��� �� ȣ��
	@RequestMapping(value="/admin/login.do",method=RequestMethod.GET)
	public String loginForm(HttpSession session) {
		session.invalidate();
		return "adminLogin";
	}
	//�α���
	@RequestMapping(value="/admin/login.do",method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("userCommand") 
	@Valid UserCommand userCommand, 
	BindingResult result, HttpSession session) {

		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + userCommand);
		}

		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return loginForm(session);
		}

		try {
			UserCommand user = userService.selectUser(userCommand.getId());

			boolean check = false;

			if(user!=null) {
				//��й�ȣ ��ġ ���� üũ
				check = user.isCheckedPasswd(cipherAES.encrypt(userCommand.getPasswd()));
				if(log.isDebugEnabled()) {
					log.debug("<<user>> : "+user);
					log.debug("<<��ġ����>> : " + check);
				}
			}

			if(user.getAuth() == 6) {
				if(check) {
					//���� ���� �α���
					session.setAttribute("user_id", user.getId());
					session.setAttribute("user_auth", user.getAuth());

					if(log.isDebugEnabled()) {
						log.debug("<<���� ����>>");
						log.debug("<<user_id>> : " + user.getId());
						log.debug("<<user_auth>> : " + user.getAuth());
					}

					return "admin";
				}else {
					//�������� 
					throw new Exception();
				}
			}else {
				//���� ����
				throw new Exception();
			}
		}catch(Exception e){
			//���� ����
			result.reject("invalidAdmin");

			if(log.isDebugEnabled()) {
				log.debug("<<���� ����>>");
			}

			return loginForm(session);
		}
	}

	//==========01_��ȭ ����_��ȭ���==========//
	//01_1_���, ��� ��
	@RequestMapping("/admin/main.do")
	public ModelAndView movie_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								   @RequestParam(value="keyfield", defaultValue="") String keyfield,
								   @RequestParam(value="keyword", defaultValue="") String keyword) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//�� ���� ���� �Ǵ� �˻��� ���� ����
		int movie_count = movieService.selectMovieCnt(map);

		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<movie_count>>: " + movie_count);
		}

		//����¡ ó��
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, movie_count, rowCount, pageCount, "main.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<MovieCommand> movie_list = null;
		if(movie_count > 0) {
			movie_list = movieService.selectMovieList(map);

			//�α� ���
			if(log.isDebugEnabled()) {
				log.debug("<movie_list>: " + movie_list);
			} 
		}

		//ModelAndView��ü ����, ������ ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movieList");
		mav.addObject("movie_count", movie_count);
		mav.addObject("movie_list", movie_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//01_2_���۵� ������ ó��
	@RequestMapping(value="/admin/main.do", method=RequestMethod.POST)
	public String movie_submit(@ModelAttribute("movie_command") @Valid MovieCommand movieCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<MovieCommand>>: " + movieCommand);
		}

		movieService.insertMovie(movieCommand);

		return "redirect:/admin/main.do";
	}

	//==========02_��ȭ ����_��ȭ ������==========//
	//02_1_���, ��� ��
	@RequestMapping("/admin/officialList.do")
	public String official_list() {

		return "officialList";
	}
	//02_2_���۵� ������ ó��
	@RequestMapping(value="/admin/officialList.do", method=RequestMethod.POST)
	public String official_submit(@ModelAttribute("official_command") @Valid OfficialsCommand officialsCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<OfficialsCommand>>: " + officialsCommand);
		}

		officialsService.insert(officialsCommand);

		return "redirect:/admin/officialList.do";
	}

	//==========03_��ȭ ����_��ȭ �帣==========//
	//03_1_�帣 ���(����¡&�˻�)
	@RequestMapping("/admin/genreList.do")
	public ModelAndView genre_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam(value="keyfield", defaultValue="") String keyfield,
			@RequestParam(value="keyword", defaultValue="") String keyword) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//�� ���� ���� �Ǵ� �˻��� ���� ����
		int genre_count = genreService.selectGenreCnt(map);

		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<genre_count>>: " + genre_count);
		}

		//����¡ ó��
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, genre_count, rowCount, pageCount, "genreList.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<GenreCommand> genre_list = null;
		if(genre_count > 0) {
			genre_list = genreService.selectGenreList(map);

			//�α� ���
			if(log.isDebugEnabled()) {
				log.debug("<genre_list>: " + genre_list);
			} 
		}

		//ModelAndView��ü ����, ������ ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genreList");
		mav.addObject("genre_count", genre_count);
		mav.addObject("genre_list", genre_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	public String genre_delete(@RequestParam("genre_num") int num) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<num>>: " + num);
		}

		genreService.deleteGenre(num);

		return "redirect:/admin/genreList.do";
	}

	//03_2_���۵� ������ ó��
	@RequestMapping(value="/admin/genreList.do", method=RequestMethod.POST)
	public String genre_submit(@ModelAttribute("genre_command") @Valid GenreCommand genreCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<genreCommand>>: " + genreCommand);
		}

		genreService.insertGenre(genreCommand);

		return "redirect:/admin/genreList.do";
	}

	//==========04_��ȭ ����_��ȭ ����==========//
	@RequestMapping("/admin/movieRating.do")
	public String process3() {

		return "movieRating";
	}

	//==========05_ȸ�� ����_ȸ�� ���==========//
	@RequestMapping("/admin/userList.do")
	public String process4() {

		return "userList";
	}

	//==========06_ȸ�� ����_�Ű� ȸ��==========//
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {

		return "reportedUser";
	}

	//==========07_�� ����_�� ����==========//
	@RequestMapping("/admin/support.do")
	public String process6() {

		return "support";
	}
}
