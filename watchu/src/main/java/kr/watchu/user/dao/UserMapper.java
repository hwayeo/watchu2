package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.watchu.user.domain.UserCommand;
 
public interface UserMapper {
	//ȸ�����
	@Insert("INSERT INTO user_basic (id,auth) VALUES (#{id},1)")
	public void insertUser(UserCommand user);
	//���������
	@Insert("INSERT INTO user_info (id,passwd,name,phone,email,profile_img,reg_date) VALUES (#{id},#{passwd},#{name},#{phone},#{email},#{profile_img},SYSDATE)")
	public void insertUserDetail(UserCommand user);
	
	//ȸ��������Ȯ��
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
