package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //다른 클래스에 포함될 객체 생성
public class Sender2 implements SenderInter{
	public void show() {
		System.out.println("Sender2 클래스의 show 메소드 수행");
		System.out.println("와우");
	}
}
