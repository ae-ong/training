package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.GogekDto;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwonlist")
	public String jikwonProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		if(session.getId() != null) {
			JikwonDto list = dataDao.damJikList((String)session.getAttribute("no"));
			String gname = "";
			model.addAttribute("list", list);
			return "loginlist";
		}else {
			ArrayList<JikwonDto> list = dataDao.jikwonList();			
			model.addAttribute("list", list);
			return "list";
		}
	}
}
