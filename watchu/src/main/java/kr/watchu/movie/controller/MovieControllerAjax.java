package kr.watchu.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.watchu.movie.domain.MovieCommand;
import kr.watchu.movie.service.MovieService;
import kr.watchu.util.PagingUtil;

@Controller
public class MovieControllerAjax {
	private int rowCount = 4;
	private int pageCount = 10;
	
	@Resource 
	private MovieService movieService;
	
	@ModelAttribute("command")
	public MovieCommand initCommand() {
		return new MovieCommand();
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