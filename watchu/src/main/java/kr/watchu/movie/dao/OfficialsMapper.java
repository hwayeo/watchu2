package kr.watchu.movie.dao;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.OfficialsCommand;

public interface OfficialsMapper {
	//���
	public void insert(OfficialsCommand officials);
	//������
	public OfficialsCommand selectOfficials(Integer off_num);
	//����
	public void update(OfficialsCommand officials);
	//����
	//������ ���� ���̺��� ������ ���� �ؾ���
	public void delete(Integer off_num);
	//���
	public int selectOffCnt(Map<String, Object> map);
	public List<OfficialsCommand> selectOffList(Map<String, Object> map);
}
