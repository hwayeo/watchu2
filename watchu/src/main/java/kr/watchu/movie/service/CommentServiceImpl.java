package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.movie.domain.RecommentCommand;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Override
	public void insertComment(CommentCommand comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentCommand selectComment(Integer comment_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(CommentCommand comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(Integer comment_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommentCommand> selectCommentList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCommentCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertRecomment(RecommentCommand recomment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecommentCommand selectRecomment(Integer recomment_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRecomment(RecommentCommand recomment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecomment(Integer recomment_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecommentCommand> selectRecommentList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectRecommentCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

}
