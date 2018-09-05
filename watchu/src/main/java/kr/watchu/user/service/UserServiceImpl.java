package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.watchu.user.dao.UserMapper;
import kr.watchu.user.domain.UserCommand;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public void insertUser(UserCommand user) {
		userMapper.insertUser(user);
		userMapper.insertUserDetail(user);	
		userMapper.insertRelation(user.getId());
	}


	@Override
	public UserCommand selectUser(String id) {
		return userMapper.selectUser(id);
	}

	@Override
	public void updateUser(UserCommand user) {
		userMapper.updateUser(user);
		
	}

	@Override
	public void deleteUser(String id) {
		userMapper.deleteUserRelation(id);
		userMapper.deleteUserDetail(id);
		userMapper.deleteUser(id);
	
		
	}

	@Override
	public int selectUserCnt(Map<String, Object> map) {
		return userMapper.selectUserCnt(map);
	}

	@Override
	public List<UserCommand> selectUserList(Map<String, Object> map) {
		return userMapper.selectUserList(map);
	}


	@Override
	public List<UserCommand> selectfollowList() {
		
		return userMapper.selectfollowList();
	}


	@Override
	public void insertFollow(String follow_id, String id) {
		userMapper.insertFollow(follow_id, id);
	}


	

	
	

}
