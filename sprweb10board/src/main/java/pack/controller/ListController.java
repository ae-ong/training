package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoImpl;
import pack.model.BoardDto;

@Controller
public class ListController {
	@Autowired
	private BoardDaoImpl daoImpl;
	
	private int tot; //전체 레코드 수
	private int plist = 10; //페이지 당 행 수
	private int pagesu; //전체 페이지 수
	
	public ArrayList<BoardDto> getListData(ArrayList<BoardDto> list, int page) {
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
		int start = (page - 1) * plist; //0, 10, 20, ...
		//System.out.println("start : " + start );
		int size = plist <= list.size() - start ? plist : list.size() - start; //삼항연산, 복기*
		
		for (int i = 0; i < size; i++) {
			result.add(i, list.get(start + i)); //복기*
			//System.out.println("i : " + i + ", start + i : " + (start + i));
		}
		return result;
	}
	
	public int getPageSu() {
		pagesu = tot / plist;
		if(tot % plist > 0) pagesu += 1;
		return pagesu;
	}
	
	@GetMapping("list")
	public String listProcess(Model model, @RequestParam("page") int page) {
		int spage = 0;
		try {
			spage = page;
		} catch (Exception e) {
			spage=1;
		}
		if(page <= 0) spage=1;
		
		//model.addAttribute("data", list); //httpservletresponse 객체에 데이터 넣기, paging이 없는 경우
		//paging 처리
		tot = daoImpl.totalCnt();
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>) daoImpl.listAll();
		ArrayList<BoardDto> result = getListData(list, spage);
		model.addAttribute("data", result);
		model.addAttribute("pagesu", getPageSu());
		model.addAttribute("page", spage);
		return "list"; //포워딩으로 넘김
	}
}
