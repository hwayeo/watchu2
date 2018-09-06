package kr.watchu.user.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.watchu.user.dao.ReportMapper;
import kr.watchu.user.domain.ReportCommand;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Resource
	private ReportMapper reportMapper;
	
	@Override
	public void insertReport(ReportCommand report) {
		reportMapper.insertReport(report);
	}

	@Override
	public ReportCommand selectDetailReport(Integer report_num) {
		return reportMapper.selectDetailReport(report_num);
	}

	@Override
	public void deleteReport(Integer report_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReportCommand> selectReportList(Map<String, Object> map) {
		return reportMapper.selectReportList(map);
	}

	@Override
	public int selectReportCnt(Map<String, Object> map) {
		return reportMapper.selectReportCnt(map);
	}

}
