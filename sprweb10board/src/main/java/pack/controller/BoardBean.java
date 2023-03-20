package pack.controller;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardBean {
	private int num, readcnt, gnum, onum, nested;
	private String name, pass, mail, title, cont, bip, bdate;
	private String searchValue, searchName;
	
	public void setBdate() { //db서버의 날짜가 아닌 클라이언트의 날짜
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		this.bdate = year + "-" + month +"-" + day;
	}
}
