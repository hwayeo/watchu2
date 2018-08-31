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
	//로그 설정
	private Logger log = Logger.getLogger(this.getClass());

	//자원 주입 받음	
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

	//자바빈 초기화
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

	//페이징을 위한 변수 선언
	private int rowCount = 50;
	private int pageCount = 10;

	//==========관리자 로그인============//
	//로그인 폼 호출
	@RequestMapping(value="/admin/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "adminLogin";
	}
	//로그인
	@RequestMapping(value="/admin/login.do",method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("userCommand") 
	@Valid UserCommand userCommand, 
	BindingResult result, HttpSession session) {

		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + userCommand);
		}

		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return loginForm();
		}

		try {
			UserCommand user = userService.selectUser(userCommand.getId());

			boolean check = false;

			if(user!=null) {
				//비밀번호 일치 여부 체크
				check = user.isCheckedPasswd(cipherAES.encrypt(userCommand.getPasswd()));
				if(log.isDebugEnabled()) {
					log.debug("<<user>> : "+user);
					log.debug("<<일치여부>> : " + check);
				}
			}

			if(user.getAuth() == 6) {
				if(check) {
					//인증 성공 로그인
					session.setAttribute("user_id", user.getId());
					session.setAttribute("user_auth", user.getAuth());

					if(log.isDebugEnabled()) {
						log.debug("<<인증 성공>>");
						log.debug("<<user_id>> : " + user.getId());
						log.debug("<<user_auth>> : " + user.getAuth());
					}

					return "admin";
				}else {
					//인증실패 
					throw new Exception();
				}
			}else {
				//권한 없음
				throw new Exception();
			}
		}catch(Exception e){
			//인증 실패
			result.reject("invalidAdmin");

			if(log.isDebugEnabled()) {
				log.debug("<<인증 실패>>");
			}

			return loginForm();
		}
	}

	//==========01_영화 관리_영화목록==========//
	//01_1_목록, 등록 폼
	@RequestMapping("/admin/main.do")
	public ModelAndView movie_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								   @RequestParam(value="keyfield", defaultValue="") String keyfield,
								   @RequestParam(value="keyword", defaultValue="") String keyword) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//총 글의 갯수 또는 검색된 글의 갯수
		int movie_count = movieService.selectMovieCnt(map);

		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<movie_count>>: " + movie_count);
		}

		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, movie_count, rowCount, pageCount, "main.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<MovieCommand> movie_list = null;
		if(movie_count > 0) {
			movie_list = movieService.selectMovieList(map);

			//로그 출력
			if(log.isDebugEnabled()) {
				log.debug("<movie_list>: " + movie_list);
			} 
		}

		//ModelAndView객체 생성, 데이터 저장
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movieList");
		mav.addObject("movie_count", movie_count);
		mav.addObject("movie_list", movie_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//01_2_전송된 데이터 처리
	@RequestMapping(value="/admin/main.do", method=RequestMethod.POST)
	public String movie_submit(@ModelAttribute("movie_command") @Valid MovieCommand movieCommand, BindingResult result, HttpServletRequest request) {
		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<MovieCommand>>: " + movieCommand);
		}

		movieService.insertMovie(movieCommand);

		return "redirect:/admin/main.do";
	}

	//==========02_영화 관리_영화 관계자==========//
	//02_1_목록, 등록 폼
	@RequestMapping("/admin/officialList.do")
	public String official_list() {

		return "officialList";
	}
	//02_2_전송된 데이터 처리
	@RequestMapping(value="/admin/officialList.do", method=RequestMethod.POST)
	public String official_submit(@ModelAttribute("official_command") @Valid OfficialsCommand officialsCommand, BindingResult result, HttpServletRequest request) {
		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<OfficialsCommand>>: " + officialsCommand);
		}

		officialsService.insert(officialsCommand);

		return "redirect:/admin/officialList.do";
	}

	//==========03_영화 관리_영화 장르==========//
	//03_1_장르 목록(페이징&검색)
	@RequestMapping("/admin/genreList.do")
	public ModelAndView genre_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam(value="keyfield", defaultValue="") String keyfield,
			@RequestParam(value="keyword", defaultValue="") String keyword) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//총 글의 갯수 또는 검색된 글의 갯수
		int genre_count = genreService.selectGenreCnt(map);

		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<genre_count>>: " + genre_count);
		}

		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, genre_count, rowCount, pageCount, "genreList.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<GenreCommand> genre_list = null;
		if(genre_count > 0) {
			genre_list = genreService.selectGenreList(map);

			//로그 출력
			if(log.isDebugEnabled()) {
				log.debug("<genre_list>: " + genre_list);
			} 
		}

		//ModelAndView객체 생성, 데이터 저장
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genreList");
		mav.addObject("genre_count", genre_count);
		mav.addObject("genre_list", genre_list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	public String genre_delete(@RequestParam("genre_num") int num) {
		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<num>>: " + num);
		}

		genreService.deleteGenre(num);

		return "redirect:/admin/genreList.do";
	}

	//03_2_전송된 데이터 처리
	@RequestMapping(value="/admin/genreList.do", method=RequestMethod.POST)
	public String genre_submit(@ModelAttribute("genre_command") @Valid GenreCommand genreCommand, BindingResult result, HttpServletRequest request) {
		//로그 출력
		if(log.isDebugEnabled()) {
			log.debug("<<genreCommand>>: " + genreCommand);
		}

		genreService.insertGenre(genreCommand);

		return "redirect:/admin/genreList.do";
	}

	//==========04_영화 관리_영화 별점==========//
	@RequestMapping("/admin/movieRating.do")
	public String process3() {

		return "movieRating";
	}

	//==========05_회원 관리_회원 목록==========//
	@RequestMapping("/admin/userList.do")
	public String process4() {

		return "userList";
	}

	//==========06_회원 관리_신고 회원==========//
	@RequestMapping("/admin/reportedUser.do")
	public String process5() {

		return "reportedUser";
	}

	//==========07_고객 지원_고객 문의==========//
	@RequestMapping("/admin/support.do")
	public String process6() {

		return "support";
	}
}
