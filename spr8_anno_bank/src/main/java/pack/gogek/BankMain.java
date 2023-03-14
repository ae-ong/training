package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankInit.xml");
		
		Gogek gogek = (Gogek) context.getBean("gogek");
		gogek.choiceBank("sinhan");
		gogek.playInputMoney(5000);
		gogek.playOutputMoney(3000);
		System.out.print("gogek - ");
		gogek.showMoney();
		
		Gogek gogek1 = (Gogek) context.getBean("gogek");
		gogek1.choiceBank("sinhan");
		gogek1.playInputMoney(8000);
		gogek1.playOutputMoney(2000);
		System.out.print("gogek1 - ");
		gogek1.showMoney();
		
		Gogek gogek3 = (Gogek) context.getBean("gogek");
		gogek3.choiceBank("hana");
		gogek3.playInputMoney(3000);
		gogek3.playOutputMoney(2000);
		System.out.print("gogek3 - ");
		gogek3.showMoney();
	}

}
