package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class SangpumController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("sangpum")
	@ResponseBody
	public Map<String, Object> sangProcess(){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		for(SangpumDto s:dataDao.getDataAll()) { //mybatis 어노테이션 이용
			data = new HashMap<String, String>();
			data.put("code", s.getCode());
			data.put("sang", s.getSang());
			data.put("su", s.getSu());
			data.put("dan", s.getDan());
			list.add(data);
		}
		System.out.println(list);
		Map<String, Object> sangList = new HashMap<String, Object>(); //키밸류 반환 위해 맵사용
		sangList.put("datas", list);
		return sangList;
	}
}
