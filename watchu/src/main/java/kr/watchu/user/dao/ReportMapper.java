package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.watchu.user.domain.ReportCommand;

public interface ReportMapper {
	
	//�Ű�
	@Insert("INSERT INTO user_report (report_num,id,report_user,report_content,reg_date) VALUES (report_seq.nextval,#{id},#{report_user},#{report_content},SYSDATE)")
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
