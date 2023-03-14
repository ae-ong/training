package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		//Annotation 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		process.displayData();
		//process.getSender().show();
		//process.getSenderInter().show();
	}
}
