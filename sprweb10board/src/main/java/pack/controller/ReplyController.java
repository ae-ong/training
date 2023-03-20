package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoImpl;

@Controller
public class ReplyController {
	@Autowired
	private BoardDaoImpl daoImpl;
	
	@GetMapping("reply")
	public String reply(@RequestParam("num")String num, @RequestParam("page")String page, Model model) {
		model.addAttribute("data", daoImpl.detail(num));
		model.addAttribute("page", page);
		return "reply";
	}
	
	@PostMapping("reply")
	public String replyProcess(BoardBean bean, @RequestParam("page")String page) {
		//onum 갱신
		bean.setOnum(bean.getOnum() + 1);
		daoImpl.updateOnum(bean);
		
		//댓글 저장
		bean.setBdate();
		bean.setNum(daoImpl.currentNum() + 1); //새글 번호
		bean.setNested(bean.getNested() + 1); //들여쓰기
		
		if(daoImpl.insertReply(bean)) {
			return "redirect:list?page=" + page; //댓글 추가 후 해당 페이지 목록보기
		}else {
			return "redirect:error";
		}
	}
}
