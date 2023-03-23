package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwonlist")
	public String jikwonProcess(HttpServletRequest request, HttpServletResponse response,
			Model model) { //pointcut 대상, 핵심 메소드, getArg()에서 불러와질 것들
		ArrayList<JikwonDto> list = dataDao.jikwonList();
		model.addAttribute("list", list);
		return "list";
	}
}
