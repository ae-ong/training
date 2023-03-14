package pack.controller;

import pack.model.ShowData;

public class MyProcessImpl {
	private int nai;
	private String name;
	
	private ShowData showData; //클래스의 포함관계
	/*
	public MyProcessImpl(int nai, String name, ShowData showData) {
		//생성자 주입
	*/
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name + ", 나이는 " + nai + ", 별명은 " + showData.processName() + 
				", 취미는 " + showData.processHobby()
				);
	}
}
