package kr.watchu.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.watchu.movie.domain.OfficialsCommand;
import kr.watchu.movie.service.OfficialsService;

@Controller
public class AdminAjaxController {	
	@Resource
	private OfficialsService officialsService;
	
	@ModelAttribute("command")
	public OfficialsCommand initCommand() {
		return new OfficialsCommand();
	}
	
	@RequestMapping("/amdin/Auto_offList.do")
	@ResponseBody
	public Map<String, Object> getAuto_offList(@RequestParam(value="keyfield",defaultValue="") String keyfield,
											   @RequestParam(value="keyword",defaultValue="" ) String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		List<OfficialsCommand> offList = null;
		offList = officialsService.selectOffAjaxList(map);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("offList", offList);
		
		return mapJson;
	}
}
