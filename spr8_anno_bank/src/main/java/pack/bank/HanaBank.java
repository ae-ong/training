package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hana")
@Scope("prototype")
public class HanaBank implements BankInter{
	private int money = 1000;
	
	public void inputMoney(int money) {
		// TODO Auto-generated method stub
		this.money = this.money + money;
	}
	
	public void outputMoney(int money) {
		// TODO Auto-generated method stub
		this.money = this.money - money;
	}
	
	public int getMoney() {
		// TODO Auto-generated method stub
		int imsi = money;
		return imsi;
	}
}
