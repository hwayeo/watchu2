package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.MovieCommand;

public interface MovieService {
	//��ȭ���
	public void insertMovie(MovieCommand movie);
	//��ȭ ������
	public MovieCommand selectMovie(Integer movie_num);
	//��ȭ ����
	public void updateMovie(MovieCommand movie);
	//��ȭ ����
	//��ȭ ������ ���� �� ���̺� �����ؾ� ��
	public void deleteMovie(Integer movie_num);

	//��ȭ ����۾�
	public int selectMovieCnt(Map<String,Object> map);
	public List<MovieCommand> selectMovieList(Map<String,Object> map);
	public int selectMovieAjaxCnt(Map<String,Object> map);
	public List<MovieCommand> selectMovieAjaxList(Map<String,Object> map);
	public int selectMovieAjaxCnt2(Map<String,Object> map);
	public List<MovieCommand> selectMovieAjaxList2(Map<String,Object> map);
}
