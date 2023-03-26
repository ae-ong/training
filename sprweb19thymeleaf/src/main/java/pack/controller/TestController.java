package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="thleaf")
public class TestController {
	@GetMapping("/ex1")
	public String abc1(Model model) {
		ItemDto dto = new ItemDto();
		dto.setId("ks1");
		dto.setName("마우스");
		dto.setPrice(5000);
		dto.setRegDate(LocalDate.now());
		
		model.addAttribute("dto", dto);
		return "show1";
	}
	
	@GetMapping("/ex2")
	public ModelAndView abc2(/*HttpServletRequest request*/) {
		List<ItemDto> list = new ArrayList<ItemDto>();
		for (int i = 1; i <= 3; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks" + i);
			dto.setName("신상품" + i);
			dto.setPrice(5000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		ModelAndView andView = new ModelAndView("show2");
		andView.addObject("dtos", list);
		//request.setAttribute("dtos", list);
		return andView;
	}
	
	@GetMapping("/ex3")
	public String abc3(Model model) {
		List<ItemDto> list = new ArrayList<ItemDto>();
		for (int i = 1; i <= 5; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks" + i);
			dto.setName("신상품" + i);
			list.add(dto);
		}
		model.addAttribute("dtos", list);
		return "show3";
	}
	
	@GetMapping("/ex4")
	public String abc4(Model model, String param1, String param2) {
		//...
		model.addAttribute("arg1", param1);
		model.addAttribute("arg2", param2);
		return "show4";
	}
	
	@GetMapping("/ex5")
	public String abc5(Model model) {
		return "show5";
	}
}
