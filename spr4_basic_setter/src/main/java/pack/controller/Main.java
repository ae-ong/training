package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		
		MyProcessImpl impl = (MyProcessImpl) context.getBean("myProcessImpl");
		impl.displayData();
	}

}
