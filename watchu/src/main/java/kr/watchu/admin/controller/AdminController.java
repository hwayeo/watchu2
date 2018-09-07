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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.movie.domain.GenreCommand;
import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.domain.OfficialsCommand;
import kr.watchu.movie.service.CommentService;
import kr.watchu.movie.service.GenreService;
import kr.watchu.movie.service.MovieService;
import kr.watchu.movie.service.MovieratedService;
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
	private CommentService commentService;
	@Resource
	private MovieratedService movieRatedService;
	
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

	//������ ����	
	@RequestMapping("/admin/admin_movieList.do")
	public ModelAndView mainProcess(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
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
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, movie_count, rowCount, pageCount, "admin_movieList.do");

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
		mav.setViewName("admin_movieList");
		mav.addObject("movie_count", movie_count);
		mav.addObject("movie_list", movie_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//====================������ �α���======================//
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

					return "redirect:/admin/admin_movieList.do";
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

	//====================01_��ȭ ����_��ȭ���====================//
	//01_1_��� �� ȣ��
	@RequestMapping(value="/admin/admin_movieWrite.do", method=RequestMethod.GET)
	public String admin_movieForm(HttpSession session, Model model) {
		//�ڹٺ� ����
		MovieCommand movie = new MovieCommand();
		model.addAttribute("movie_command", movie);
		
		return "admin_movieWrite";
	}
	
	//01_2_���۵� ������ ó��
	@RequestMapping(value="/admin/admin_movieWrite.do", method=RequestMethod.POST)
	public String movie_submit(@ModelAttribute("movie_command") @Valid MovieCommand movieCommand, BindingResult result, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<MovieCommand>>: " + movieCommand);
		}
		
		movieService.insertMovie(movieCommand);

		return "redirect:/admin/admin_movieList.do";
	}

	//01_3_��ȭ ��&����
	//�󼼺���&���� �� ȣ��
	@RequestMapping(value="/admin/admin_movieDetail.do", method=RequestMethod.GET)
	public ModelAndView admin_movieDetail(@RequestParam("movie_num") int movie_num, Model model) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<movie_num>>: " + movie_num);
		}
		
		MovieCommand movie = movieService.selectMovie(movie_num);
		model.addAttribute("movie_command", movie);
		
		return new ModelAndView("admin_movieDetail", "movie", movie);
	}
	
	//�̹��� ���
	@RequestMapping("/admin/image_View.do")
	public ModelAndView viewImage2(@RequestParam("movie_num") int movie_num,
								   @RequestParam("type") String type) {
		//�� ���� �����͸� �޾� ��ü ����
		MovieCommand movie = movieService.selectMovie(movie_num);
		if(log.isDebugEnabled()) {
			log.debug("[[movie_num]] : " + movie_num);
		}
		//�����͸� ModelAndView��ü�� �������� ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
						//�Ӽ���		�Ӽ���(byte[]�� ������)
		mav.addObject("filename","poster.jpg");
		if(type.equals("banner")) {
			mav.addObject("imageFile", movie.getBanner_img());
		}else {
			mav.addObject("imageFile", movie.getPoster_img());
		}
				
		return mav;
	}
	
	//���� ������ ���۵� ������ ó��
	@RequestMapping(value="/admin/admin_movieDetail.do", method=RequestMethod.POST)
	public String adminMovie_submit(@ModelAttribute("movie_command") @Valid MovieCommand movieCommand, BindingResult result, HttpSession session, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<movieCommand>>: " + movieCommand);
		}
		
		//��ȭ ���� ����
		movieService.updateMovie(movieCommand);
		
		return "redirect:/admin/admin_movieList.do";
	}
	
	//01_4_��ȭ ���� ����
	@RequestMapping("/admin/admin_movieDelete.do")
	public String adminMovie_delete(@RequestParam("movie_num") int movie_num) {
		//�α����
		if(log.isDebugEnabled()) {
			log.debug("<<movie_num>>: " + movie_num);
		}
		
		//��ȭ ���� ���� �ش� ��ȭ�� �޸� �ڸ�Ʈ ����
		commentService.deleteCommentByMovie(movie_num);
		//��ȭ ���� ���� �ش� ��ȭ�� �޸� �� ����
		movieRatedService.deleteRatedByMovie(movie_num);
		//�� ����
		movieService.deleteMovie(movie_num);
		
		return "redirect:/admin/admin_movieList.do";
	}
	//====================02_��ȭ ����_��ȭ ������====================//
	//02_1_���, ��� ��
	@RequestMapping("/admin/officialList.do")
	public ModelAndView official_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam(value="keyfield", defaultValue="") String keyfield,
			@RequestParam(value="keyword", defaultValue="") String keyword) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//�� ���� ���� �Ǵ� �˻��� ���� ����
		int official_count = officialsService.selectOffCnt(map);

		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<offical_count>>: " + official_count);
		}

		//����¡ ó��
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, official_count, rowCount, pageCount, "officialList.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<OfficialsCommand> official_list = null;
		if(official_count > 0) {
			official_list = officialsService.selectOffList(map);

			//�α� ���
			if(log.isDebugEnabled()) {
				log.debug("<official_list>: " + official_list);
			} 
		}

		//ModelAndView��ü ����, ������ ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("officialList");
		mav.addObject("official_count", official_count);
		mav.addObject("official_list", official_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
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

	//02_3_������ ��&����
	//�󼼺���&������ ȣ��
	@RequestMapping(value="/admin/offcialDetail.do", method=RequestMethod.GET)
	public ModelAndView off_detail(@RequestParam("off_num") int off_num, Model model) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<off_num>>: " + off_num);
		}

		OfficialsCommand officials = officialsService.selectOfficials(off_num);
		model.addAttribute("official_command", officials);

		return new ModelAndView("officialDetail", "officials", officials);
	}
	
	//�̹��� ���
	@RequestMapping("/admin/off_imgView.do")
	public ModelAndView viewImage(@RequestParam("off_num") int off_num) {
		//�� ���� �����͸� �޾� ��ü ����
		OfficialsCommand officials = officialsService.selectOfficials(off_num);
				
		//�����͸� ModelAndView��ü�� �������� ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
						//�Ӽ���		�Ӽ���(byte[]�� ������)
		mav.addObject("filename", "officials.jpg");
		mav.addObject("imageFile", officials.getOff_photo());
				
		return mav;
	}
	
	//���� ������ ���۵� ������ ó��
	@RequestMapping(value="/admin/offcialDetail.do", method=RequestMethod.POST)
	public String officials_submit(@ModelAttribute("official_command") @Valid OfficialsCommand officialsCommand, BindingResult result, HttpSession session, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<officialsCommand>>: " + officialsCommand);
		}
		
		//������ ����
		officialsService.update(officialsCommand);
		
		return "redirect:/admin/officialList.do";
	}

	//02_4_������ ����
	@RequestMapping("/admin/officialDelete.do")
	public String officials_delete(@RequestParam("off_num") int off_num) {
		//�α����
		if(log.isDebugEnabled()) {
			log.debug("<<off_num>>: " + off_num);
		}
		
		//�� ����
		officialsService.delete(off_num);
		
		return "redirect:/admin/officialList.do";
	}

	//====================03_��ȭ ����_��ȭ �帣====================//
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
	
	//03_3_�帣 ����
	//�󼼺���&������ ȣ��
	@RequestMapping(value="/admin/genreDetail.do", method=RequestMethod.GET)
	public ModelAndView genre_detail(@RequestParam("genre_num") int genre_num, Model model) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<genre_num>>: " + genre_num);
		}

		GenreCommand genre = genreService.selectGenre(genre_num);
		model.addAttribute("genre_command", genre);

		return new ModelAndView("genreDetail", "genre", genre);
	}
	
	//���� ������ ���۵� ������ ó��
	@RequestMapping(value="/admin/genreDetail.do", method=RequestMethod.POST)
	public String genre_submit(@ModelAttribute("genre_command") @Valid GenreCommand genreCommand, BindingResult result, HttpSession session, HttpServletRequest request) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<genreCommand>>: " + genreCommand);
		}
		
		//�� ����
		genreService.updateGenre(genreCommand);
		
		return "redirect:/admin/genreList.do";
	}
	
	//03_4_�帣 ����
	@RequestMapping("/admin/genreDelete.do")
	public String genre_delete(@RequestParam("genre_num") int genre_num) {
		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<genre_num>>: " + genre_num);
		}
		
		genreService.deleteGenre(genre_num);
		
		return "redirect:/admin/genreList.do";
	}
	
	//�帣 ���� ����
/*	@ResponseBody
	@RequestMapping("check_genreDel.do")
	public c_genreDel(){
		
	}*/

	
	//====================04_��ȭ ����_��ȭ ����====================//
	@RequestMapping("/admin/movieRating.do")
	public String process3() {

		return "movieRating";
	}

	//====================05_ȸ�� ����_ȸ�� ���====================//
	//05_1_ȸ�����&�˻�
	@RequestMapping("/admin/userList.do")
	public ModelAndView user_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								  @RequestParam(value="keyfield", defaultValue="") String keyfield,
								  @RequestParam(value="keyword", defaultValue="") String keyword) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//�� ���� ���� �Ǵ� �˻��� ���� ����
		int user_count = userService.selectUserCnt(map);

		//�α� ���
		if(log.isDebugEnabled()) {
			log.debug("<<user_count>>: " + user_count);
		}

		//����¡ ó��
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, user_count, rowCount, pageCount, "userList.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<UserCommand> user_list = null;
		if(user_count > 0) {
			user_list = userService.selectUserList(map);

			//�α� ���
			if(log.isDebugEnabled()) {
				log.debug("<user_list>: " + user_list);
			} 
		}

		//ModelAndView��ü ����, ������ ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userList");
		mav.addObject("user_count", user_count);
		mav.addObject("user_list", user_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	
	//====================06_ȸ�� ����_�Ű� ȸ��====================//
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {

		return "reportedUser";
	}

	//====================07_�� ����_�� ����====================//
	@RequestMapping("/admin/support.do")
	public String process6() {

		return "support";
	}
	
	//======�̹��� ��====///
}
