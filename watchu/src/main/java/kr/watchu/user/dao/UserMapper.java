package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import kr.watchu.user.domain.UserCommand;

public interface UserMapper {
	
	//ȸ�����
	public void insertUser(UserCommand user);
	//������
	public UserCommand selectUser(String id);
	//����
	public void updateUser(UserCommand user);
	//����
	public void deleteUser(String id);
	//���
	public int selectUserCnt(Map<String, Object> map);
	public List<UserCommand> selectUserList(Map<String,Object> map);
	
	//ģ������(�ȷο�,�ȷο�,���)
	//ȸ�����Խ� user_relation ���̺� ���
	public void insertRelation(String id);
	
}
