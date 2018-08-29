package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.watchu.movie.domain.GenreCommand;

public interface GenreMapper {
	//�帣�߰�
	@Insert("INSERT INTO movie_genre (genre_num, genre) VALUES (genre_seq.nextval, #{genre})")
	public void insertGenre(GenreCommand genre);
	//������ -> ��� �����Ұ� ����
	//����
	public void updateGenre(GenreCommand genre);
	//����
	public void deleteGenre(Integer genre_num);
	//���
	public int selectGenreCnt(Map<String, Object> map);
	public List<GenreCommand> selectGenreList(Map<String,Object> map);
}
