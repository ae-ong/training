package pack.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	//log 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("login")
	public String submitCall() {
		return "redirect:http://localhost/login.html"; //클라이언트를 통해 부름, WEB-INF의 views파일에는 접근 불가
	}
	
	//방법1 : 전통적 방법으로 파라미터 값 받기
	/*
	@GetMapping("loginget")
	public String submit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//System.out.println(id + " " + pwd);
		logger.info(id + " " + pwd);	//INFO : 어떠한 상태 변경과 같은 정보성 메시지를 나타냄
		
		String data = "";
		if(id.equals("abc") && pwd.equals("123")) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		
		model.addAttribute("data", data);
		return "result";
	}
	*/
	//방법2 : Spring 방법으로 파라미터 값 받기
	@GetMapping("loginget")
	public String submit(@RequestParam(value="id")String id, @RequestParam(value="pwd", defaultValue = "123")int pwd, Model model) {
		
		String data = "";
		if(id.equals("abc") && pwd == 123) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		
		model.addAttribute("data", data);
		return "result";
	}

}
