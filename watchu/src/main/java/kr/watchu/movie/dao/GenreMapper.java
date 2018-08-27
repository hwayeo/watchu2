package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.GenreCommand;

public interface GenreMapper {
	//장르추가
	public void insertGenre(GenreCommand genre);
	//상세정보 -> 없어도 무관할것 같은
	//수정
	public void updateGenre(GenreCommand genre);
	//삭제
	public void deleteGenre(Integer genre_num);
	//목록
	public int selectGenreCnt(Map<String, Object> map);
	public List<GenreCommand> selectGenreList(Map<String,Object> map);
}
