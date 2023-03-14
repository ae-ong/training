package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//setter injection test

		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MyProcess process = (MyProcess) context.getBean("myProcess");
		System.out.println(process);  //System.out.println(process.toString()); toString오버라이딩함
		
	}
}
