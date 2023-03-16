package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.MemDto;

@Service
@Controller
public class MemController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("list")
	public String listProcess(Model model) {
		ArrayList<MemDto> list = (ArrayList<MemDto>) dataDao.getDataAll();
		model.addAttribute("datas", list);
		return "list"; //서비스 메소드 request, response 가 넘어감
	}
	
	@PostMapping("insert")
	public String insertProcess(MemBean bean) {
		boolean b = dataDao.insert(bean);
		if(b) {
			//return "redirect:http://localhost/list"; //insert는 리다이렉트 사용해야 한다(포워딩하면 db에 문제발생)
			return "redirect:list";
		}else {
			return "redirect:http://localhost/error.html";
		}
	}
	
	@GetMapping("update")
	public String update(Model model, @RequestParam("num") String num) {
		MemDto dto = dataDao.getData(num);
		model.addAttribute("data", dto);
		return "update"; //리다이렉트 하면 안넘어감
	}
	
	@PostMapping("update")
	public String updateProcess(MemBean bean) {
		boolean b = dataDao.update(bean);
		if(b) {
			return "redirect:http://localhost/list";
		}else {
			return "redirect:http://localhost/error.html";
		}
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num) {
		boolean b = dataDao.delete(num);
		if(b) {
			return "redirect:http://localhost/list";
		}else {
			return "redirect:http://localhost/error.html";
		}
	}
}
