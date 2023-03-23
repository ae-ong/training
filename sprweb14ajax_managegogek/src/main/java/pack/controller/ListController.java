package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

	@GetMapping("list")
	public String gogekInfo() {
		return "findjikwon";
	}
}
