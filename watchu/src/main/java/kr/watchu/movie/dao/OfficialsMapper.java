package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.watchu.movie.domain.OfficialsCommand;
 
public interface OfficialsMapper {
	//���
	@Insert("INSERT INTO officials (off_num, name, jobs, filmograp, off_photo) "
			+ "VALUES (officials_seq.nextval, #{name}, #{jobs}, #{filmograp}, #{off_photo})")
	public void insert(OfficialsCommand officials);
	//������
	@Select("SELECT * FROM officials WHERE off_num=#{off_num}")
	public OfficialsCommand selectOfficials(Integer off_num);
	//����
	//@Update("UPDATE officials SET name=#{name}, jobs=#{jobs}, filmograp=#{filmograp}, off_photo=#{off_photo} WHERE off_num=#{off_num}")
	public void update(OfficialsCommand officials);
	//����
	//������ ���� ���̺��� ������ ���� �ؾ���
	@Delete("DELETE FROM officials WHERE off_num=#{off_num}")
	public void delete(Integer off_num);
	//���
	public int selectOffCnt(Map<String, Object> map);
	public List<OfficialsCommand> selectOffList(Map<String, Object> map);
	
	//�ڵ��ϼ� ajax
	public List<OfficialsCommand> selectOffAjaxList(Map<String, Object> map);
	
}
