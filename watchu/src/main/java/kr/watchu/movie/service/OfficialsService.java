package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import kr.watchu.movie.domain.OfficialsCommand;

public interface OfficialsService {
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
	
	//�ڵ��ϼ� ajax
	public List<OfficialsCommand> selectOffAjaxList(Map<String, Object> map);
}
