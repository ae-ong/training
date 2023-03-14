package anno2_resource;

import org.springframework.stereotype.Component;

@Component //부품으로 사용될 클래스
public class Abc2 {
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
}