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
	 * CommentCommand, RecommentCommant 둘다 사용
	 */
	
	//======= 코멘트
	//코멘트 쓰기
	@Insert("INSERT INTO movie_comment (comment_num, movie_num, id, content, reg_date) "
			+ "VALUES (comment_seq.nextval, #{movie_num}, #{id}, #{content}, SYSDATE)") 
	public void insertComment(CommentCommand comment);
	//상세정보
	@Select("SELECT * FROM movie_comment WHERE movie_num=#{movie_num} AND id=#{id}")
	public CommentCommand selectComment(Map<String,Object> map);
	//수정
	@Update("UPDATE movie_comment SET content=#{content} WHERE movie_num=#{movie_num} AND id=#{id}")
	public void updateComment(CommentCommand comment);
	//삭제
	@Delete("DELETE FROM movie_comment WHERE comment_num=#{comment_num}")
	public void deleteComment(Integer comment_num);
	
	//목록
	@Select("SELECT * FROM movie_comment WHERE movie_num=#{movie_num} ORDER BY movie_num DESC")
	public List<CommentCommand> selectCommentList(Integer movie_num);
	//카운트
	@Select("SELECT COUNT(*) FROM movie_comment WHERE movie_num=#{movie_num}")
	public int selectCommentCnt(Integer movie_num);
	
	//======= 코멘트 댓글
	//코멘트 쓰기
	public void insertRecomment(RecommentCommand recomment);
	//상세정보
	public RecommentCommand selectRecomment(Integer recomment_num);
	//수정
	public void updateRecomment(RecommentCommand recomment);
	//삭제
	public void deleteRecomment(Integer recomment_num);
	
	//목록
	public List<RecommentCommand> selectRecommentList(Map<String, Object> map);
	//카운트
	public int selectRecommentCnt(Map<String, Object> map);
}
