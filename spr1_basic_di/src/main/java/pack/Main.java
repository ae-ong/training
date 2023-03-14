package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//프로젝트 빌드 도구 : Maven
		//장점 : 의존성 설정을 간결하게 해줌, 동일한 방식의 배포를 가능하게 함, ...
		//순수 자바의 경우
		Message1 message1 = new Message1(); //각각의 클래스 인스턴스 생성 후 메소드 사용
		message1.sayHello("홍길동");
		Message2 message2 = new Message2();
		message2.sayHello("고길동");
		System.out.println("---");
		
		//인터페이스 타입 변수 선언 후
		MessageInter inter;
		//각 클래스의 인스턴스 대입 후 메소드 사용
		inter = message1;
		inter.sayHello("홍길동2");
		inter = message2;
		inter.sayHello("고길동2");
		System.out.println("**************************");
		//스프링 컨테이너 BeanFactory(스프링 빈을 관리)의 하위 인터페이스로 부가 기능을 갖는다, 싱글톤 컨테이너로 불림
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml"); //ApplicationContext 인터페이스를 구현한 클래스
		MessageInter inter2 = (MessageInter) context.getBean("mBean"); //xml파일의 설정클래스 아이디를 통해 bean데이터 얻어옴
		inter2.sayHello("홍길동3");
	}
}
