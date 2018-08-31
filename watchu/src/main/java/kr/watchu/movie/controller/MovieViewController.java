package kr.watchu.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.service.MovieService;
import kr.watchu.util.PagingUtil;
import kr.watchu.util.StringUtil;

@Controller
public class MovieViewController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MovieService movieService;
	
	//글 상세 보기용
	@RequestMapping("/movie/movieDetail.do")
	public ModelAndView movieDetail(@RequestParam("movie_num") int movie_num) {
		
		if(log.isDebugEnabled()){
			log.debug("<<movie_num>> : " + movie_num);
		}
		
		MovieCommand movie = movieService.selectMovie(movie_num);
		
		return new ModelAndView("movieDetail","movie",movie);
	}
}
