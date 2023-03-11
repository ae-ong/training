package aop2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	
	@Autowired
	private ArticleInter articleInter;
	
	public void selectData_process1() {
		System.out.println("selectData_process1 수행");
		articleInter.selectAll();
	}
	
	public void selectData_process2() {
		System.out.println("selectData_process2 처리");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("3초 처리 완료");
	}
}
