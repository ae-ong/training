package pack.controller;

import pack.model.CalcInter;

public class MyProcess {
	private String name;
	private int su;
	private CalcInter inter; //다형성, 클래스의 포함관계
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSu(int su) {
		this.su = su;
	}
	
	public void setInter(CalcInter inter) {
		this.inter = inter;
	}
	
	@Override
	public String toString() {
		int[] re = inter.numCalc(su);
		String str = "";
		for (int i = 0; i < re.length; i++) {
			str += su + "*" + (i+1) + "=" + re[i] + "\n";
		}
		return "작성자 : " + name + "\n" + su + "단 결과 \n" + str;
	}
}
