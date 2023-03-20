package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.BoardDaoImpl;
import pack.model.BoardDto;

@Controller //디스패처서블릿의 지배를 받음
public class SearchController {
	@Autowired
	private BoardDaoImpl daoImpl;
	
	@GetMapping("search")
	public String searchProcess(BoardBean bean, Model model) {
		List<BoardDto> list = (List<BoardDto>) daoImpl.search(bean);
		model.addAttribute("data", list);
		model.addAttribute("page", "1");
		return "list";
	}
}
