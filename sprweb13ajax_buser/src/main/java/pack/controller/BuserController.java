package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.BuserDto;
import pack.model.DataDao;

@Controller
public class BuserController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("buserlist")
	public String buserProcess(Model model) {
		ArrayList<BuserDto> blist = dataDao.buserList();
		model.addAttribute("blist", blist);
		return "list";
	}
}
