package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.GogekDto;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jiklist")
	public String listProcess(Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("ginfo")
	public String gogekProcess(@RequestParam("no") String no, @RequestParam("name") String name, Model model) {
		List<GogekDto> dto = dataDao.getGogek(no);
		model.addAttribute("jikwon_name", name);
		model.addAttribute("g", dto);
		return "ginfo";
	}
}
