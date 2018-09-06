package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.GenreCommand;

public interface GenreService {
	//�帣�߰�
	public void insertGenre(GenreCommand genre);
	//������ 
	public GenreCommand selectGenre(Integer genre_num);
	//����
	public void updateGenre(GenreCommand genre);
	//����
	public void deleteGenre(Integer genre_num);
	//���
	public int selectGenreCnt(Map<String, Object> map);
	public List<GenreCommand> selectGenreList(Map<String,Object> map);
	
	//�ڵ��ϼ� ajax
	public List<GenreCommand> selectGenreAjaxList(Map<String, Object> map);
}
