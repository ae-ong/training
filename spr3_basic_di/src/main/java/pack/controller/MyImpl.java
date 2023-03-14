package pack.controller;

import java.util.Scanner;

import pack.model.MoneyInter;
//컨트롤러
public class MyImpl implements MyInter{
	private MoneyInter inter; //클래스의 포함관계
	private int re[];
	
	public MyImpl(MoneyInter inter) { //생성자 주입
		this.inter = inter;
	}

	public void inputMoney() {
		//키보드 금액 입력
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("금액 입력 : ");
			int myMoney = scanner.nextInt();
			re = inter.calcMoney(myMoney);
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e);
		}	
	}
	
	public void showResult() {
		//배열에 담긴 연산 결과 출력
		StringBuffer sb = new StringBuffer();
		sb.append("만원 : " + re[0] + "\n");
		sb.append("천원 : " + re[1] + "\n");
		sb.append("백원 : " + re[2] + "\n");
		sb.append("십원 : " + re[3] + "\n");
		sb.append("일원 : " + re[4] + "\n");
		System.out.println(sb.toString());
	}
}
