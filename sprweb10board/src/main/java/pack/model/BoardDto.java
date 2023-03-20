package pack.model;

import lombok.Data;

@Data
public class BoardDto {
	private int num, readcnt, gnum, onum, nested;
	private String name, pass, mail, title, cont, bip, bdate;
}
