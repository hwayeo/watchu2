package kr.watchu.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.service.MovieService;
import kr.watchu.util.PagingUtil;

@Controller
public class MovieController {
	
	private int rowCount = 4;
	private int pageCount = 4;
	
	@Resource
	private MovieService movieService;
	
	//===영화 메인 목록===//
	@RequestMapping("/movie/movieHome.do")
	public ModelAndView movieHome(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("keyfield",keyfield);
		map.put("keyword", keyword);
		
		int count = movieService.selectMovieCnt(map);
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"movieHome.do"); 
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MovieCommand> list = null;
		
		list = movieService.selectMovieList(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movieHome");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav;
	}
	
	@RequestMapping("/movie/movieList.do")
	public String movieList() {
		return "movieList";
	}
	
	@RequestMapping("/movie/movieEva.do")
	public String movieEva() {
		return "movieEva";
	}
}
