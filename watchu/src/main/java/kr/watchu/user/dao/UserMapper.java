package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.watchu.user.domain.UserCommand;

public interface UserMapper {
	
	//회원등록
	@Insert("INSERT INTO user_basic (id) VALUES (#{id})")
	public void insertUser(UserCommand user);
	//상세정보
	@Insert("INSERT INTO user_info (id,name,passwd,phone,email,reg_date) VALUES (#{id},#{name},#{passwd},#{phone},#{email},SYSDATE)")
	public UserCommand insertUserDetail(String id);
	//수정
	public void updateUser(UserCommand user);
	//삭제
	public void deleteUser(String id);
	//목록
	public int selectUserCnt(Map<String, Object> map);
	public List<UserCommand> selectUserList(Map<String,Object> map);
	
	//친구관계(팔로우,팔로워,블락)
	//회원가입시 user_relation 테이블에 등록
	public void insertRelation(String id);
	
}
