package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("arrange.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/arrange.xml");
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("classpath:arrange.xml"); MessageImpl impl =
		 * (MessageImpl) context.getBean("mImpl"); impl.sayHi();
		 */
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		MessageImpl impl = (MessageImpl) context.getBean("mImpl");
		impl.sayHi();
		MessageImpl impl2 = (MessageImpl) context.getBean("mImpl");
		impl2.sayHi();
		System.out.println(impl + " " + impl2); //싱글톤으로 해시코드가 같다
		
		System.out.println("-------------------------------");
		//MessageInter inter = (MessageImpl)context.getBean("mImpl");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		MessageInter inter2 = context.getBean("mImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();
		
		System.out.println("-----환경을 클래스로 작성------------------");
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
		MessageInter inter3 = (MessageInter) context2.getBean("mImpl");
		inter3.sayHi();
	}
}