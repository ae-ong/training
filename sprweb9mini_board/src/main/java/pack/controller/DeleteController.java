package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num) {
		boolean b = boardDao.delete(num);
		if(b) {
			return "redirect:/list"; //수정 후 목록보기			
		}else {
			return "error";
		}
	}
}
