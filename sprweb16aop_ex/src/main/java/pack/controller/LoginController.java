package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.GogekDto;

@Controller
public class LoginController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("login")
	public String postLogin(HttpSession session, @RequestParam("no") String no, @RequestParam("name") String name) {
		GogekDto gogekDto = dataDao.gogekLogin(no);
		if(gogekDto != null) {
			String retName = gogekDto.getGogek_name();
			String retDamNo = gogekDto.getGogek_no();
			if(retName.equals(name)) {
				session.setAttribute("name", retName);
				session.setAttribute("no", retDamNo);
				System.out.println(retDamNo + retName);
			}
		}
		return "redirect:/jikwonlist";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/index.html";
	}
}
