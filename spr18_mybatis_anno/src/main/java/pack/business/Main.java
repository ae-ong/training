package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		ProcessInter processInter = (ProcessInter) context.getBean("processImpl");
		processInter.dataShow();
	}

}
