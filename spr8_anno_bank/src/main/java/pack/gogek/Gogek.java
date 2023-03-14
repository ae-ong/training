package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.BankInter;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@ComponentScan("pack.bank") //프로세스 클래스에서 사용할 부품 클래스가 있는 패키지를 스캔
@Scope("prototype") //계좌의 공유를 막기 위해(기본값인 싱글톤이면 계좌가 공유되게 됨)
public class Gogek {
	//@Autowired
	private BankInter bankInter;
	
	@Autowired
	@Qualifier("sinhanBank")
	private SinhanBank sinhanBank;
	
	@Resource(name="hana")
	private HanaBank hanaBank;
	
	public void choiceBank(String choice) { //고객이 은행을 선택해 새로운 계좌를 만들고 입출금할 예정
		if(choice.equals("sinhan")) {
			bankInter = sinhanBank;
		}else if(choice.equals("hana")) {
			bankInter = hanaBank;
		}
	}
	
	public void playInputMoney(int money) {
		bankInter.inputMoney(money);
	}
	
	public void playOutputMoney(int money) {
		bankInter.outputMoney(money);
	}
	
	private String msg;
	@PostConstruct //생성자 수행 후 초기화 필요시 사용
	public void abc() {
		msg = "계좌 잔고 : ";
	}
	
	@PreDestroy //마무리 할 때 사용
	public void def() {
		if(sinhanBank != null) sinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	public void showMoney() {
		System.out.println(msg + bankInter.getMoney());
	}
}
