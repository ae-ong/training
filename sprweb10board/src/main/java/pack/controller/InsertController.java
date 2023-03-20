package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDaoImpl;

@Controller
public class InsertController {
	@Autowired
	private BoardDaoImpl daoImpl;
	
	@GetMapping("insert")
	public String insertForm() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String insertProcess(BoardBean bean) {
		bean.setBdate();
		int newNum = daoImpl.currentNum() + 1; //가장 큰 번호에서 1 추가로 새글 번호 도출
		bean.setNum(newNum);
		bean.setGnum(newNum); //댓글 번호는 원글의 레코드 번호와 같다
		
		boolean b = daoImpl.insert(bean);
		if(b) {
			return "redirect:/list?page=1"; //추가 후 목록 보기
		}else {
			return "redirect:/error";
		}
	}
}
