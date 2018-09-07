package kr.watchu.movie.service;

import java.util.Map;
import kr.watchu.movie.domain.MovieratedCommand;

public interface MovieratedService {
	//��ȭ ���� ���
	public void insertMovierated(MovieratedCommand im);
	
	//���� ȣ��
	public MovieratedCommand selectMovierated(Map<String,Object> map);
	
	//��ȭ ���� ����(update) -> ������ ��ȭ�� ���ߴ��� Ȯ�� �� ������ ������Ʈ
	public void updateMovierated(MovieratedCommand im);
	
	//��ȭ ���� �� �� ����
	public void deleteRatedByMovie(Integer movie_num);
}