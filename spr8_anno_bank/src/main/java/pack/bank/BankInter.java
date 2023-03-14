package pack.bank;

public interface BankInter {
	void inputMoney(int money); //입금
	void outputMoney(int money); //출금
	int getMoney(); //잔고 확인
}
