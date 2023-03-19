package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class ListController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("list") // get, post 다받는다, get으로 바꿔주기, 각각의 list 기능 구별**
	public String list(Model model) {
		List<Board> list = boardDao.list();
		model.addAttribute("list", list);
		return "list";
	}
}
