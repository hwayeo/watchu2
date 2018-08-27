package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.watchu.user.domain.UserCommand;

public interface UserMapper {
	
	//ȸ�����
	@Insert("INSERT INTO user_basic (id) VALUES (#{id})")
	public void insertUser(UserCommand user);
	//������
	@Insert("INSERT INTO user_info (id,name,passwd,phone,email,reg_date) VALUES (#{id},#{name},#{passwd},#{phone},#{email},SYSDATE)")
	public UserCommand insertUserDetail(String id);
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
