package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.watchu.user.domain.ContactCommand;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Override
	public void insertContact(ContactCommand contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContactCommand selectContact(Integer contact_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateContact(ContactCommand contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(Integer contact_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectContactCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ContactCommand> selectContactList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
