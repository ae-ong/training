package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class JikController {

	@Autowired
	private DataDao dao;
	
	@GetMapping("jikwonlist")
	public String jikwonlist(HttpServletRequest request, 
			HttpServletResponse response, Model model) {
		ArrayList<JikwonDto> jlist = null;
		
		HttpSession session = request.getSession();
		String gno = (String)session.getAttribute("gno");
		String gname = (String)session.getAttribute("gname");
		
		//System.out.println("gname : " + gname);
		//System.out.println("gno : " + gno);
		
		if(gno != null) {
			jlist = dao.getDamJik(gno, gname);
		}else {
			jlist = dao.getJikListAll();
		}
		
		model.addAttribute("jlist", jlist);
		
		return "list";
	}
}
