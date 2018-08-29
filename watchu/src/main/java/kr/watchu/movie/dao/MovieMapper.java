package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.watchu.movie.domain.MovieCommand;
  
public interface MovieMapper {
	//��ȭ���
	@Insert("INSERT INTO movie_info (movie_num, title, country, released, director, actors, summary, poster_img, banner_img, main_genre, sub_genre, trailer, reg_date) VALUES (movie_seq.nextval, #{title}, "
		+ "#{country}, #{released}, #{director}, #{actors}, #{summary}, #{poster_img}, #{banner_img}, #{main_genre}, #{sub_genre}, #{trailer}, SYSDATE)")
	public void insertMovie(MovieCommand movie);
	//��ȭ ������
	public MovieCommand selectMovie(Integer num);
	//��ȭ ���� 
	public void updateMovie(MovieCommand movie);
	//��ȭ ����
	//��ȭ ������ ���� �� ���̺� �����ؾ� ��
	public void deleteMovie(Integer num);
	
	//��ȭ ����۾�
	public int selectMovieCnt(Map<String,Object> map);
	public List<MovieCommand> selectMovieList(Map<String,Object> map);
}
