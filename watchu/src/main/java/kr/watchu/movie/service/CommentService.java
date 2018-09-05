package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.RecommentCommand;

public interface CommentService {
	//======= 코멘트
	//코멘트 쓰기
	public void insertComment(CommentCommand comment);
	//상세정보
	public CommentCommand selectComment(Map<String,Object> map);
	//수정
	public void updateComment(CommentCommand comment);
	//삭제
	public void deleteComment(Integer comment_num);

	//목록
	public List<CommentCommand> selectCommentList(Integer movie_num);
	//카운트
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
