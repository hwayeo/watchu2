package kr.watchu.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.watchu.movie.dao.OfficialsMapper;
import kr.watchu.movie.domain.OfficialsCommand;

@Service("officialsService")
public class OfficialsServiceImpl implements OfficialsService {

	private OfficialsMapper OfficialsMapper;
	
	@Override
	public void insert(OfficialsCommand officials) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfficialsCommand selectOfficials(Integer off_num) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OfficialsCommand> selectOffList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
