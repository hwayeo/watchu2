package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.watchu.movie.dao.OfficialsMapper;
import kr.watchu.movie.domain.OfficialsCommand;

@Service("officialsService")
public class OfficialsServiceImpl implements OfficialsService {
	@Resource
	private OfficialsMapper officialsMapper;
	
	@Override
	public void insert(OfficialsCommand officials) {
		officialsMapper.insert(officials);
	}

	@Override
	public OfficialsCommand selectOfficials(Integer off_num) {
		return officialsMapper.selectOfficials(off_num);
	}

	@Override
	public void update(OfficialsCommand officials) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer off_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectOffCnt(Map<String, Object> map) {
		return officialsMapper.selectOffCnt(map);
	}

	@Override
	public List<OfficialsCommand> selectOffList(Map<String, Object> map) {
		return officialsMapper.selectOffList(map);
	}

}
