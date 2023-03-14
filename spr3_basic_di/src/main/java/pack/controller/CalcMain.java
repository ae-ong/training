package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app_init.xml");
		
		MyInter myInter = (MyInter) context.getBean("myImpl");
		myInter.inputMoney();
		myInter.showResult();
	}
}
