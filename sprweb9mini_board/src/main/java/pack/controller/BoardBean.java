package pack.controller;

import lombok.Data;

@Data
public class BoardBean {
	private int num, readcnt;
	private String author, title, content, bwrite;
	private String searchName, searchValue;
}
