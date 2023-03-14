package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SangpumMain {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("sang_init.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyInter myInter = (MyInter) context.getBean("myImpl");
		myInter.inputMoney();
		myInter.showResult();
	}

}
