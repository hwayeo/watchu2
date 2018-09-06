package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.watchu.movie.domain.CommentCommand;
import kr.watchu.user.domain.UserCommand;
 
public interface UserMapper {
	//ȸ�����
	@Insert("INSERT INTO user_basic (id,auth,permit) VALUES (#{id},1,#{permit})")
	public void insertUser(UserCommand user);
	//���������
	@Insert("INSERT INTO user_info (id,passwd,name,phone,email,profile_img,reg_date) VALUES (#{id},#{passwd},#{name},#{phone},#{email},#{profile_img},SYSDATE)")
	public void insertUserDetail(UserCommand user);
	
	//ȸ��������Ȯ��
	@Select("select * from user_basic b left outer join user_info i on b.id=i.id left outer join user_relation c on b.id=c.id where i.id=#{id}")
	public UserCommand selectUser(String id);
	//����
	@Update("update user_info set passwd=#{passwd},name=#{name},phone=#{phone},email=#{email},profile_img=#{profile_img} where id=#{id}")
	public void updateUser(UserCommand user);
	
	//����
	@Delete("delete from user_basic where id=#{id}")
	public void deleteUser(String id);
	@Delete("delete from user_info where id=#{id}")
	public void deleteUserDetail(String id);
	@Delete("delete from user_relation where id=#{id}")
	public void deleteUserRelation(String id);
	
	//ģ�����
	public int selectUserCnt(Map<String, Object> map);	
	public List<UserCommand> selectUserList(Map<String,Object> map);
	
	//ģ������(�ȷο�,�ȷο�,���)
	//ȸ�����Խ� user_relation ���̺� ���
	@Insert("INSERT INTO user_relation (id) VALUES (#{id})")
	public void insertRelation(String id);
	//�� �ȷο쿡 ���� �߰�
	@Update("update user_relation set follow=#{follow} where id=#{id}")
	public void insertFollow(UserCommand user);
	//���� �ȷο��� �� �߰�
	@Update("update user_relation set follower=#{follower} where id=#{id}")
	public void insertFollower(UserCommand user);
	//��� �߰�
	@Update("update user_relation set block=#{block} where id=#{id}")
	public void insertBlock(UserCommand user);
	
	
	// ���
	@Select("SELECT * FROM movie_comment b left outer join user_info i on b.id=i.id WHERE i.id=#{id}")
	public List<CommentCommand> CommentList(String id);
}
