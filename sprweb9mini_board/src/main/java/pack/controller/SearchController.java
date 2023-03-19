package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class SearchController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("search")
	public String search(BoardBean bean, Model model) {
		List<Board> slist = boardDao.search(bean);
		model.addAttribute("list", slist);
		return "list";
	}
}
