package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorProcessController {
	@GetMapping("err")
	public String errProcess() {
		return "error";
	}
}
