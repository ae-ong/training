package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class GogekController {

	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwon")
	@ResponseBody
	public JikwonDto jikwonData(@RequestParam("gogek_no")String gogek_no, @RequestParam("gogek_name")String name) {
		JikwonDto dto = dataDao.jikwon(gogek_no, name);
		return dto;
		
	}
}
