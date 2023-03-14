package anno3_etc;

import org.springframework.stereotype.Component;

@Component
public class DataInfo {
	private String name = "홍길동";
	private String part = "AI부";
	public String job = "프로그래머"; //get x
	
	public String getName() {
		return name;
	}
	
	public String getPart() {
		return part;
	}
	
}
