package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.RecommentCommand;

public interface CommentService {
	//======= �ڸ�Ʈ
	//�ڸ�Ʈ ����
	public void insertComment(CommentCommand comment);
	//������
	public CommentCommand selectComment(Map<String,Object> map);
	//����
	public void updateComment(CommentCommand comment);
	//����
	public void deleteComment(Integer comment_num);

	public void deleteCommentByMovie(Integer movie_num);
	//���
	public List<CommentCommand> selectCommentList(Integer movie_num);
	//ī��Ʈ
	public int selectCommentCnt(Integer movie_num);

	//�������������� ���� �� �ڸ�Ʈ�� ��ȯ�ϴ� �޼���
	public List<CommentCommand> selectMyCommentList(String id);

	public int selectMyCommentCnt(String id);
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
