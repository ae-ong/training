package anno2_resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class AbcProcess {
	@Resource(name="abc1") //이름에 의한 매핑, java가 지원
	private Abc1 abc1;
	
	//@Resource(name="abc2")
	private Abc2 abc2;

	@Resource(name="abc2")
	public void setAbc2(Abc2 abc2) {
		this.abc2 = abc2;
	}
	
	public void showData() {
		abc1.setIrum("홍길동");
		abc2.setNai(22);
		
		String str = "결과 : 이름은 " + abc1.getIrum();
		str += ", 나이는 " + abc2.getNai();
		System.out.println(str);
	}
}
