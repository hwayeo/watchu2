package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

import kr.watchu.user.domain.ReportCommand;

public interface ReportService {
	
	//�Ű�
	public void insertReport(ReportCommand report);
	//������
	public ReportCommand selectReport(Integer report_num);
	//�Ű� ���
	public void deleteReport(Integer report_num);
	//���
	public List<ReportCommand> selectReportList(Map<String,Object> map);
	//ī��Ʈ
	public int selectReportCnt(Map<String,Object> map);
}
