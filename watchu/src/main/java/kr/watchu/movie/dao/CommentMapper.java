package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.RecommentCommand;

public interface CommentMapper {
	/*
	 * CommentCommand, RecommentCommant 둘다 사용
	 */
	
	//======= 코멘트
	//코멘트 쓰기
	public void insertComment(CommentCommand comment);
	//상세정보
	public CommentCommand selectComment(Integer comment_num);
	//수정
	public void updateComment(CommentCommand comment);
	//삭제
	public void deleteComment(Integer comment_num);
	
	//목록
	public List<CommentCommand> selectCommentList(Map<String, Object> map);
	//카운트
	public int selectCommentCnt(Map<String, Object> map);
	
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
