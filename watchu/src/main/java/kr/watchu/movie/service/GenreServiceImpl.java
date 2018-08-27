package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.watchu.movie.dao.GenreMapper;
import kr.watchu.movie.domain.GenreCommand;

@Service("genreService")
public class GenreServiceImpl implements GenreService{
	@Resource
	private GenreMapper genreMapper;

	@Override
	public void insertGenre(GenreCommand genre) {
		genreMapper.insertGenre(genre);
	}

	@Override
	public void updateGenre(GenreCommand genre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGenre(Integer genre_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectGenreCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GenreCommand> selectGenreList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
