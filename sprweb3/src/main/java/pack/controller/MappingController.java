package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingController {
	@GetMapping(value="abc/login", params="type=admin")
	public String abc(Model model) {
		model.addAttribute("message", "관리자");
		return "list";
	}
	@GetMapping(value="abc/login", params="type=user")
	public String def(Model model) {
		model.addAttribute("message", "일반 고객");
		return "list";
	}
	@GetMapping(value="abc/login", params="!type")
	public String ghi(Model model) {
		model.addAttribute("message", "type 값이 없어요");
		return "list";
	}
	
	@PostMapping(value = "abc/login")
	public String jkl(@RequestParam("type") String type, Model model) {
		//model.addAttribute("message", "type : " + type);
		//return "list";
		if(type.equals("login")) {
			model.addAttribute("message", type);
		}else if(type.equalsIgnoreCase("korea")) {
			model.addAttribute("message", "대한민국");
		}else {
			model.addAttribute("message", "기타");
		}
		return "list";
	}
	
	@GetMapping(value="def/{url}") //요청명의 일부를 정보로 받기
	public String mno(@RequestParam("name")String name, @PathVariable String url, Model model) {
		model.addAttribute("message", "name : " + name + ", url : " + url);
		return "list";
	}
	
	@GetMapping(value="ent/{co}/singer/{singer}") //요청명의 일부를 정보로 받기
	public String pqr(@RequestParam("title")String title, @PathVariable String co, @PathVariable String singer, Model model) {
		String ss = "소속사 : " + co + ", 가수 : " + singer + ", 신곡 : " + title;
		model.addAttribute("message", ss);
		return "list";
	}
}
