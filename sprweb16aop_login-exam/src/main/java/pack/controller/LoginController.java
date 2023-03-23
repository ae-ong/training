package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class LoginController {
	
	@Autowired
	private DataDao dao;
	
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("login")
	public String postLogin(HttpSession session,
			@RequestParam("no")String no, @RequestParam("name")String name) {
		JikwonDto godto = dao.getGogekInfo(no);
		
		if(godto != null) {
			String gName = godto.getGogek_name();
			String gNo = godto.getGogek_no();
			
			if(gName.equals(name) && gNo.equals(no)) {
				session.setAttribute("gname", gName);
				session.setAttribute("gno", gNo);
			}
		}
		
		return "redirect:/jikwonlist";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("gname");
		session.removeAttribute("gno");
		// session.invalidate(); 모든 세션 제거(위험함)
		return "redirect:/index.html";
	}
	
}
