package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.watchu.user.domain.ContactCommand;

public interface ContactMapper {
	//���Ǳ� ���
	@Insert("INSERT INTO user_contact (contact_num,id,content,filename,upload_file,reg_date,title) VALUES (contact_seq.nextval,#{id},#{content},#{filename},#{upload_file},SYSDATE,#{title})")
	public void insertContact(ContactCommand contact);
	//������
	@Select("SELECT * FROM user_contact WHERE contact_num=#{contact_num}")
	public ContactCommand selectContact(Integer contact_num);
	//����
	@Update("UPDATE user_contact SET title=#{title},content=#{content},upload_file=#{upload_file},filename=#{filename} WHERE contact_num=#{contact_num}")

	public void updateContact(ContactCommand contact);
	//����
	@Delete("DELETE FROM user_contact WHERE contact_num=#{contact_num}")
	public void deleteContact(Integer contact_num);
	
	//���
	//����
	public int selectContactCnt(Map<String, Object> map);
	//����Ʈ
	public List<ContactCommand> selectContactList(Map<String,Object> map);
}
