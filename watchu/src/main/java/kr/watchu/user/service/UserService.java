package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

import kr.watchu.user.domain.UserCommand;

public interface UserService {
	//회원등록
	public void insertUser(UserCommand user);
	//상세정보
	public UserCommand selectUser(String id);
	//수정
	public void updateUser(UserCommand user);
	//삭제
	public void deleteUser(String id);
	//목록
	public int selectUserCnt(Map<String, Object> map);
	public List<UserCommand> selectUserList(Map<String,Object> map);
}
