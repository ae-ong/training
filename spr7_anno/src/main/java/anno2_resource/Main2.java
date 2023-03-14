package anno2_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		//Annotation 사용
		//ApplicationContext context = new ClassPathXmlApplicationContext("anno2.xml");
		String[] metas = new String[] {"anno2.xml", "anno2_1.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(metas[0]);
		AbcProcess process = context.getBean("abcProcess", AbcProcess.class);
		process.showData();
	}
}
