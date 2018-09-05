package kr.watchu.movie.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.watchu.movie.domain.MovieratedCommand;
import kr.watchu.movie.service.MovieratedService;

@Controller
public class MovieratedController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource 
	private MovieratedService ms;
	
	@ModelAttribute("rateCommand")
	public MovieratedCommand initCommandRate() {
		return new MovieratedCommand();
	}
	
	//��ȭ �򰡸�� ȣ��
	@RequestMapping("/movie/rating.do")
	@ResponseBody
	public Map<String,String> insertRated(@ModelAttribute("rateCommand") MovieratedCommand im) {
		
		
		if(log.isDebugEnabled()) {
			log.debug("[[rateCommand]] : " + im);
		}
		Map<String,String> map = new HashMap<String, String>();
	
		//���� ��ȭ �� �����͸� �޾ƿ��� ���� �Ķ���Ͱ��� �־��ִ� ��
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id", im.getId());
		data.put("movie_num", im.getMovie_num());
		
		MovieratedCommand origin = ms.selectMovierated(data);
		
		if(origin == null) {
			//insert
			ms.insertMovierated(im);
			map.put("result", "insert");
		}else {
			//update
			ms.updateMovierated(im);
			map.put("result", "update");
		}
		
		return map;		
	}
}