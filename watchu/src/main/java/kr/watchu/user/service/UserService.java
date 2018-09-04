package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

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
	/*//�ȷο�(��õģ��)���
	public List<UserCommand> selectfollowList();*/
	//�ȷ��׹�ư
	public void insertFollow(UserCommand user);
}
