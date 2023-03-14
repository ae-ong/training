package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.GogekDto;
import pack.model.JikwonDto;

@Controller
public class MyController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("gogek")
	public String myProcess(Model model) {
		ArrayList<GogekDto> list = dataDao.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping(value = "damdang")
	public String gname(@RequestParam("gno") String gno, Model model) {
		ArrayList<JikwonDto> list = dataDao.getJikwon(gno);
		model.addAttribute("jdatas", list);
		return "jlist";
	}
}
