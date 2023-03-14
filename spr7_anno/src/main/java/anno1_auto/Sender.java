package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //다른 클래스에 포함될 객체 생성
//@Component("sender") //객체 생성
//@Scope("singleton") //prototype, session, request, singleton(기본값)
public class Sender implements SenderInter{
	public void show() {
		System.out.println("show 메소드 수행");
	}
}
