package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	@GetMapping("login")
	public String login(HttpSession session) {
		if(session.getAttribute("idkey") == null) {
			return "redirect:login.html";
		}else {
			return "redirect:/buserlist";
		}
	}
	
	@PostMapping("login")
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		if(id.equals("kor")&&pwd.equals("111")) {
			session.setAttribute("idkey", id);
			return "redirect:buserlist";
		}else {
			return "redirect:/err.html";
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("idkey"); //특정 세션 날리기
		//session.invalidate(); 모든 세션 날리기
		return "redirect:/index.html";
	}
}
