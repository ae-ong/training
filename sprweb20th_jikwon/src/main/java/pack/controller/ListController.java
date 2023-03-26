package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDto;
import pack.model.DataProcess;

@Controller
public class ListController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("testdb")
	public String selectProcess(Model model) {
		ArrayList<DataDto> list = (ArrayList<DataDto>) dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "show"; //forwarding
	}
	
	@GetMapping("search")
	public String searchProcess(FormBean bean, Model model) {
		ArrayList<DataDto> slist = (ArrayList<DataDto>) dataProcess.getDataSearch(bean);
		model.addAttribute("datas", slist);
		return "show";
	}
}
