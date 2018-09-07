package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.user.domain.UserCommand;

public interface UserService {
	//ȸ�����
	public void insertUser(UserCommand user);
	//����������
	public UserCommand selectUser(String id); 
	//����
	public void updateUser(UserCommand user);
	//����
	public void deleteUser(String id);
	//���
	public int selectUserCnt(Map<String, Object> map);
	public List<UserCommand> selectUserList(Map<String,Object> map);
	//�ȷο�,�ȷο�,���
	public void insertFollow(UserCommand user);
	public void insertFollower(UserCommand user);
	public void insertBlock(UserCommand user);
	
	// ���
	public List<CommentCommand> CommentList(String id);

}
