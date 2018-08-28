package kr.watchu.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String movieHome() {		
		return "movieHome";
	}
	
	@RequestMapping("/movie/movieList.do")
	public String movieList() {
		return "movieList";
	}
	
	@RequestMapping("/movie/movieEva.do")
	public String movieEva() {
		return "movieEva";
	}
	    
	@RequestMapping("/movie/movieMlist.do")
	@ResponseBody
	public Map<String,Object> getMovieList(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		int count = movieService.selectMovieCnt(map);
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MovieCommand> list = null;
		
		if(count > 0) { 
			list = movieService.selectMovieList(map);
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);		
		 
		return mapJson;
	}
}
