package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;

public class Main2 {

	public static void main(String[] args) {
		//전통적인 방법
		DataDaoImpl daoImpl = new DataDaoImpl(); //데이터 접근 객체 생성
		DataDao dataDao = daoImpl; //생성한 객체를 상위 인터페이스 변수에 대입
		SelectServiceImpl impl = new SelectServiceImpl(dataDao); //데이터 접근 인터페이스 객체를 서비스 처리 객체에 대입
		SelectService selectService = impl; //인터페이스에 하위 클래스 객체 대입
		selectService.selectProcess(); //컨트롤러
		
		System.out.println("\n스프링으로 처리 ---");
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		SelectService selectService2 = (SelectService) context.getBean("selectServiceImpl"); //인터페이스에 넣고
		selectService2.selectProcess(); //인터페이스로 불러주기
		
		System.out.println("\n스프링으로 처리2 : 환경설정을 class로 작성 ---");
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
		SelectService selectService3 = (SelectService) context2.getBean("selectServiceImpl");
		selectService3.selectProcess();
	}
}