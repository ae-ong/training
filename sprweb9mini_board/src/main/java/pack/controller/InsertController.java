package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class InsertController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("insert")
	public String insert() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String insertsubmit(BoardBean bean) {
		boolean b = boardDao.insertData(bean);
		if(b) {
			return "redirect:/list"; //추가 후 목록보기			
		}else {
			return "error";
		}
	}
}
