package pack.aspect;

import org.springframework.stereotype.Component;

@Component //관심사항(보안, 로그인, 트랜잭션)
public class SecurityClass {
	public void mySecurity() {
		System.out.println("핵심 메소드 전에 보안 작업 설정 준비");
	}
}
