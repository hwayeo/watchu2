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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectUserCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserCommand> selectUserList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
