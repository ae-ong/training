package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("aopinit.xml");
		
		// AOP 적용 전
		MessageInter inter=(MessageInter)context.getBean("targetBean");
		inter.sayHi();
		
		System.out.println("----------------------------------");
		// AOP 적용 후
		MessageInter inter2=(MessageInter)context.getBean("proxy");
		inter2.sayHi();
	}
}	
