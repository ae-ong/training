package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("thymetest")
	public String abc(Model model) {
		model.addAttribute("msg", "타임리프 처리"); //httpservletrequest에 담음
		
		model.addAttribute("msg2", "oscar");
		
		//DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("마우스");
		sangpum.setPrice("1200");
		model.addAttribute("sangpum", sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		Sangpum sangpum2 = new Sangpum();
		sangpum2.setCode("20");
		sangpum2.setSang("키보드");
		sangpum2.setPrice("5200");
		list.add(sangpum2);
		
		model.addAttribute("list", list);
		
		return "test1";
	}
}
