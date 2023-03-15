package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller //디스패처 서블릿(컨트롤러)과 모델 사이를 연결해줌
public class InsertController { 
	@Autowired
	private MemberDao memberDao;
	
	@ModelAttribute("command")
	public MemberBean formBack() {
		return new MemberBean();
	}
	
	@GetMapping("insert")
	public String form() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String submit(MemberBean bean, Model model) {
		memberDao.insData(bean);
		return "redirect:/list"; //추가 후 목록보기, 리다이렉트로 주소가 바뀜
	}
}
