package kr.watchu.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.watchu.user.domain.ReportCommand;

public interface ReportMapper {
	
	//�Ű�
	@Insert("INSERT INTO user_report (report_num,id,report_user,report_content,reg_date) VALUES (report_seq.nextval,#{id},#{report_user},#{report_content},sysdate)")
	public void insertReport(ReportCommand report);
	
	//�Ű������
	@Select("select * from user_report where report_num=#{report_num}")
	public ReportCommand selectDetailReport(Integer report_num);
	//�Ű� ���
	public void deleteReport(Integer report_num);
	
	//���
	public List<ReportCommand> selectReportList(Map<String,Object> map);
	public int selectReportCnt(Map<String,Object> map);
}
