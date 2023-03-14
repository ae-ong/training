package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhanBank implements BankInter{
	private int money = 5000;
	
	public void inputMoney(int money) {
		// TODO Auto-generated method stub
		this.money += money;
	}
	
	public void outputMoney(int money) {
		// TODO Auto-generated method stub
		this.money -= money;
	}
	
	public int getMoney() {
		// TODO Auto-generated method stub
		return money;
	}
}
