package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoImpl;

@Controller
public class DeleteControlller {
	@Autowired
	private BoardDaoImpl daoImpl;
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num, @RequestParam("page") String page) {
		//비밀번호 일치 여부 확인 생략됨
		if(daoImpl.delete(num)) return "redirect:list?page=" + page;
		else return "redirect:error";
		
	}
}
