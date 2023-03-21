package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	@Autowired
	private MyModel myModel;
	
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons(){
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("name", "한국인");
		data.put("age", "22");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "신기해");
		data.put("age", "32");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "신길동");
		data.put("age", "31");
		dataList.add(data);
		
		//return data;
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		return data2;
	}
}
