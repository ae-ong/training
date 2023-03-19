package pack.model;

import lombok.Data;

@Data
public class Board {
	private int num, readcnt;
	private String author, title, content, bwrite;
}
