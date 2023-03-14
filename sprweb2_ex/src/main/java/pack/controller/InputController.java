package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.ScoreBean;
import pack.model.ScoreModel;

@Controller
public class InputController {
	@Autowired
	private ScoreModel scoreModel;
	
	@GetMapping("insdata")
	public String submitCall() {
		return "redirect:http://localhost/input.html";
	}
	
	@PostMapping("score.do")
	public String submit(ScoreBean bean, Model model) {
		model.addAttribute("data", scoreModel.compute(bean));
		return "display";
	}
}
