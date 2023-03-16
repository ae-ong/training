package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jiklist")
	public String listProcess(Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataAll();
		ArrayList<JikwonDto> blist = (ArrayList<JikwonDto>)dataDao.getBuserName();
		model.addAttribute("datas", list);
		model.addAttribute("bdatas", blist);
		return "list";
	}
	
	@GetMapping("search")
	public String searchProcess(FormBean bean, Model model) {
		ArrayList<JikwonDto> blist = (ArrayList<JikwonDto>)dataDao.getBuserName();
		if(bean.getSearchValue().equals("all")) {
			ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataAll();
			model.addAttribute("datas", list);
		}else {
			ArrayList<JikwonDto> slist = (ArrayList<JikwonDto>) dataDao.getDataSearch(bean);
			model.addAttribute("datas", slist);			
		}
		model.addAttribute("bdatas", blist);
		return "list";
	}
	
	@GetMapping("binfo")
	public String buserProcess(@RequestParam("bname") String bname, Model model) {
		JikwonDto dto = dataDao.getBuser(bname);
		model.addAttribute("b", dto);
		return "binfo";
	}
}
