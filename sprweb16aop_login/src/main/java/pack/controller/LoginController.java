package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

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
		JikwonDto jikwonDto = dataDao.jikwonLogin(no);
		if(jikwonDto != null) {
			String retName = jikwonDto.getJikwon_name();
			if(retName.equals(name)) { //사용자가 입력한 이름과 jikwon 테이블의 이름이 같은 경우
				session.setAttribute("name", retName);
				
			}
		}
		return "redirect:/jikwonlist"; //로그인이 성공하면 핵심 로직 메소드 처리 결과 확인
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		//session.invalidate();
		return "redirect:/index.html";
	}
}
