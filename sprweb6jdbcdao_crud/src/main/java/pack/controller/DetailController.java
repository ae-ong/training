package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class DetailController { //상세보기, 수정, 삭제
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("detail")
	public String detailProcess(@RequestParam("id") String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		model.addAttribute("member", dto);
		return "detail";
	}
	
	//@GetMapping("update")
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String upform(@RequestParam("id") String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		model.addAttribute("command", dto); // command 객체는 insert에서 만듦
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String upProcess(MemberBean bean) {
		memberDao.upData(bean); //업데이트 하고 돌아옴
		return "redirect:/list"; //수정 후 목록보기
	}
	
	@GetMapping("delete")
	public String deleteProcess(@RequestParam("id") String id) {
		memberDao.delData(id);
		return "redirect:/list"; //삭제 후 목록보기
	}
}
