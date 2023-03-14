package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter{
	private SangpumInter inter;
	int re;
	String name;
	
	public MyImpl(SangpumInter inter) {
		this.inter = inter;
	}
	
	public void inputMoney() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("상품명 입력 : ");
			name = scanner.nextLine();
			System.out.print("수량 입력 : ");
			int ea = scanner.nextInt();
			System.out.print("단가 입력 : ");
			int price = scanner.nextInt();
			re = inter.calcMoney(ea, price);
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e);
		}
		
	}
	
	public void showResult() {
		StringBuffer sb = new StringBuffer();
		sb.append("상품명 : " + name + "\t");
		sb.append("금액 : " + re);
		System.out.println(sb.toString());
	}
}
