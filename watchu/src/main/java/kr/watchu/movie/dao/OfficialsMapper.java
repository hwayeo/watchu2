package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.watchu.movie.domain.OfficialsCommand;
 
public interface OfficialsMapper {
	//등록
	@Insert("INSERT INTO officials (off_num, name, jobs, filmograp, off_photo) "
			+ "VALUES (officials_seq.nextval, #{name}, #{jobs}, #{filmograp}, #{off_photo})")
	public void insert(OfficialsCommand officials);
	//상세정보
	@Select("SELECT * FROM officials WHERE off_num=#{off_num}")
	public OfficialsCommand selectOfficials(Integer off_num);
	//수정
	public void update(OfficialsCommand officials);
	//삭제
	//삭제시 관련 테이블의 정보도 삭제 해야함
	public void delete(Integer off_num);
	//목록
	public int selectOffCnt(Map<String, Object> map);
	public List<OfficialsCommand> selectOffList(Map<String, Object> map);
}
