package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MyModelInter;

@Controller
public class TestController {
	@Autowired
	private MyModelInter modelInter;
	
	@GetMapping("aoptest")
	public String abc(Model model) {
		String result1 = modelInter.processMsg();
		String result2 = modelInter.businessMsg();
		
		model.addAttribute("data1", result1);
		model.addAttribute("data2", result2);
		return "list";
	}
}
