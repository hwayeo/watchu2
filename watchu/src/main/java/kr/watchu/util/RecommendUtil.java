package kr.watchu.util;

import java.util.List;

import kr.watchu.movie.domain.MovieCommand;

public class RecommendUtil {
	
	private List<MovieCommand> recommendedList;
	
	/*
	 * ���� �� ���ڰ�
	 * 
	 * ������� ��
	 * 
	 * 
	 */
	public RecommendUtil() {
		
	}
	
	public List<MovieCommand> getRecommendList(){
		return recommendedList;
	}
}
