package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.watchu.movie.domain.GenreCommand;
import kr.watchu.movie.domain.OfficialsCommand;

public interface GenreMapper {
	//�帣�߰�
	@Insert("INSERT INTO movie_genre (genre_num, genre) VALUES (genre_seq.nextval, #{genre})")
	public void insertGenre(GenreCommand genre);
	//������
	@Select("SELECT * FROM movie_genre WHERE genre_num=#{genre_num}")
	public GenreCommand selectGenre(Integer genre_num);
	//����
	@Update("UPDATE movie_genre SET genre=#{genre} WHERE genre_num=#{genre_num}")
	public void updateGenre(GenreCommand genre);
	//����
	@Delete("DELETE FROM movie_genre WHERE genre_num=#{genre_num}")
	public void deleteGenre(Integer genre_num);
	//���
	public int selectGenreCnt(Map<String, Object> map);
	public List<GenreCommand> selectGenreList(Map<String,Object> map);
	
	//�ڵ��ϼ� ajax
	public List<GenreCommand> selectGenreAjaxList(Map<String, Object> map);
}
