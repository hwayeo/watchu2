package kr.watchu.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.watchu.movie.domain.OfficialsCommand;
import kr.watchu.movie.service.OfficialsService;

@Controller
public class AdminAjaxController {	
	
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private OfficialsService officialsService;
	
	@ModelAttribute("command")
	public OfficialsCommand initCommand() {
		return new OfficialsCommand();
	}
	
	@RequestMapping("/admin/auto_offList.do")
	@ResponseBody
	public Map<String, Object> getAuto_offList(@RequestParam(value="keyfield",defaultValue="") String keyfield,
											   @RequestParam(value="keyword",defaultValue="" ) String keyword){
		
		
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> mapJson = new HashMap<String, Object>();
		data.put("keyfield", keyfield);
		data.put("keyword", keyword);
		
		List<OfficialsCommand> list = officialsService.selectOffAjaxList(data);
		mapJson.put("list", list);
		if(log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		return mapJson;
	}
}
