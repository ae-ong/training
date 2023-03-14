package pack.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // 인스턴스 생성, 클라이언트와 데이터 입출력을 제어하는 클래스에 적용
public class TestController {

	@RequestMapping("test1") // 클라이언트 요청을 처리할 메소드를 지정, 내부적으로 HttpServletRequest사용, 중간에 핸들러 매핑 존재(숨겨져있음)
	public ModelAndView abc() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("list"); //list.jsp 수행
//		modelAndView.addObject("msg", "스프링 만세"); //아래의 두줄을 의미
//		HttpServletRequest request = new HttpServletRequest();
//		request.setAttribute("msg", "스프링 만세");
//		return modelAndView;

		return new ModelAndView("list", "msg", "스프링 만세"); // forwarding 서버에서 서버파일을 불러오기, redirect아님
	}

	// @RequestMapping(value = "test2", method = RequestMethod.GET) //get방식만 처리
	@RequestMapping(value = { "test2", "good", "abc/def" }, method = RequestMethod.GET)
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "스프링 만세2");
	}

	@GetMapping("test3")
	// @GetMapping(value= {"test3", "hello","world/nice"})
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "스프링 만세3");
	}

	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "스프링 만세4");
		//request.setAttribute("msg", "스프링 만세"); 동일 의미
		return "list"; //파일명만 적기
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST)
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "post 만세5");
	}
	
	@PostMapping("test6")
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "post 만세6");
	}
	
	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg", "post 만세7");
		return "list";
	}
	
	@GetMapping("test8")
	@ResponseBody //파일명을 문자열로 반환
	public String abc8() {
		String value = "실제로는 모델을 다녀온 결과를 반환, Java Object : String, Map, JSON, ..."; //파일명
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("허균");
		return dto; //JSON 자동 지원
	}
}
