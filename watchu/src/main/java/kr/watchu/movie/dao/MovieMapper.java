package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.watchu.movie.domain.MovieCommand;
  
public interface MovieMapper {
	//��ȭ���
	@Insert("INSERT INTO movie_info (movie_num, title, country, released, director, actors, summary, poster_img, banner_img, main_genre, sub_genre, trailer, reg_date) VALUES (movie_seq.nextval, #{title}, "
		+ "#{country}, #{released}, #{director}, #{actors}, #{summary}, #{poster_img}, #{banner_img}, #{main_genre}, #{sub_genre}, #{trailer}, SYSDATE)")
	public void insertMovie(MovieCommand movie);
	//��ȭ ������
	@Select("SELECT * FROM movie_info WHERE movie_num=#{movie_num}")
	public MovieCommand selectMovie(Integer movie_num);
	//��ȭ ����
	@Update("UPDATE movie_info SET title=#{title}, country=#{country}, released=#{released}, director=#{director}, actors=#{actors}, summary=#{summary}, poster_img=#{poster_img}, banner_img=#{banner_img}, main_genre=#{main_genre}, sub_genre=#{sub_genre}, trailer=#{trailer} WHERE movie_num=#{movie_num}")
	public void updateMovie(MovieCommand movie);
	//��ȭ ����
	//��ȭ ������ ���� �� ���̺� �����ؾ� ��
	@Delete("DELETE FROM movie_info WHERE movie_num=#{movie_num}")
	public void deleteMovie(Integer movie_num);
	
	//��ȭ ����۾�
	public int selectMovieCnt(Map<String,Object> map);
	public List<MovieCommand> selectMovieList(Map<String,Object> map);
	public int selectMovieAjaxCnt(Map<String,Object> map);
	public List<MovieCommand> selectMovieAjaxList(Map<String,Object> map);
	public int selectMovieAjaxCnt2(Map<String,Object> map);
	public List<MovieCommand> selectMovieAjaxList2(Map<String,Object> map);
}
