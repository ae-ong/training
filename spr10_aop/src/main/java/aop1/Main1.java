package aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("initaop1.xml");
		LogicInter inter=(LogicInter)context.getBean("logicImpl");
		
		inter.selectData_process1();
		inter.selectData_process2();
		
		
	}
}
