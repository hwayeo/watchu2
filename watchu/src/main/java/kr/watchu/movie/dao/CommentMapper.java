package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.RecommentCommand;

public interface CommentMapper {
	/*
	 * CommentCommand, RecommentCommant �Ѵ� ���
	 */
	
	//======= �ڸ�Ʈ
	//�ڸ�Ʈ ����
	public void insertComment(CommentCommand comment);
	//������
	public CommentCommand selectComment(Integer comment_num);
	//����
	public void updateComment(CommentCommand comment);
	//����
	public void deleteComment(Integer comment_num);
	
	//���
	public List<CommentCommand> selectCommentList(Map<String, Object> map);
	//ī��Ʈ
	public int selectCommentCnt(Map<String, Object> map);
	
	//======= �ڸ�Ʈ ���
	//�ڸ�Ʈ ����
	public void insertRecomment(RecommentCommand recomment);
	//������
	public RecommentCommand selectRecomment(Integer recomment_num);
	//����
	public void updateRecomment(RecommentCommand recomment);
	//����
	public void deleteRecomment(Integer recomment_num);
	
	//���
	public List<RecommentCommand> selectRecommentList(Map<String, Object> map);
	//ī��Ʈ
	public int selectRecommentCnt(Map<String, Object> map);
}
