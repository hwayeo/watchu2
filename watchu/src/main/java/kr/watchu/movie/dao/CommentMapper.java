package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.RecommentCommand;

public interface CommentMapper {
	/*
	 * CommentCommand, RecommentCommant �Ѵ� ���
	 */
	
	//======= �ڸ�Ʈ
	//�ڸ�Ʈ ����
	@Insert("INSERT INTO movie_comment (comment_num, movie_num, id, content, reg_date) "
			+ "VALUES (comment_seq.nextval, #{movie_num}, #{id}, #{content}, SYSDATE)") 
	public void insertComment(CommentCommand comment);
	//������
	@Select("SELECT * FROM movie_comment WHERE movie_num=#{movie_num} AND id=#{id}")
	public CommentCommand selectComment(Map<String,Object> map);
	//����
	@Update("UPDATE movie_comment SET content=#{content} WHERE movie_num=#{movie_num} AND id=#{id}")
	public void updateComment(CommentCommand comment);
	//����
	@Delete("DELETE FROM movie_comment WHERE comment_num=#{comment_num}")
	public void deleteComment(Integer comment_num);
	//��ȭ ���� �� �ڸ�Ʈ ����
	@Delete("DELETE FROM movie_comment WHERE movie_num=#{movie_num}")
	public void deleteCommentByMovie(Integer movie_num);
	
	//���
	@Select("SELECT * FROM movie_comment WHERE movie_num=#{movie_num} ORDER BY movie_num DESC")
	public List<CommentCommand> selectCommentList(Integer movie_num);
	//ī��Ʈ
	@Select("SELECT COUNT(*) FROM movie_comment WHERE movie_num=#{movie_num}")
	public int selectCommentCnt(Integer movie_num);
	
	//�������������� ���� �� �ڸ�Ʈ�� ��ȯ�ϴ� �޼���
	@Select("SELECT * FROM movie_comment WHERE id=#{id} ORDER BY comment_num DESC")
	public List<CommentCommand> selectMyCommentList(String id);
	@Select("SELECT COUNT(*) FROM movie_comment WHERE id=#{id}")
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
