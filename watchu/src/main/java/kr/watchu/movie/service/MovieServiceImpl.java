package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.watchu.movie.dao.MovieMapper;
import kr.watchu.movie.domain.MovieCommand;


@Service("movieService")
public class MovieServiceImpl implements MovieService {

	private MovieMapper movieMapper;
	
	@Override
	public void insertMovie(MovieCommand movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MovieCommand selectMovie(Integer num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMovie(MovieCommand movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMovie(Integer num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectMovieCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MovieCommand> selectMovieList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
