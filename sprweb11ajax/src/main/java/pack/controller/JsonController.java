package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
	@Autowired
	private MyModel myModel;
	
	@GetMapping("list")
	@ResponseBody //반환객체를 HTTP 응답 객체로 반환(내부적으로 jackson lib가 지원됨)
	public MyModel getJson(@RequestParam("name")String name) {
		myModel.setName(name);
		myModel.setSkills(new String[] {"자바 전문 개발", "DB 관리"});
		return myModel;
	}
}
