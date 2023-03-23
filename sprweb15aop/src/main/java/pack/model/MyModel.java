package pack.model;

import org.springframework.stereotype.Repository;

@Repository
public class MyModel implements MyModelInter{
	@Override
	public String processMsg() {
		System.out.println("processMsg 핵심 메소드 수행");
		return "Spring AOP 이해";
	}
	
	@Override
	public String businessMsg() {
		System.out.println("businessMsg 핵심 메소드 처리");
		return "Spring AOP의 의미있는 활용";
	}
}
