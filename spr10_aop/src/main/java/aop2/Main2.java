package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("initaop2.xml");
		LogicInter inter=(LogicInter)context.getBean("logicImpl");
		inter.selectData_process1();
		inter.selectData_process2();
		
		
	}
}
