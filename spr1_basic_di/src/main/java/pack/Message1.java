package pack;

public class Message1 implements MessageInter{ //파생 클래스
	public void sayHello(String name) { //추상 메소드 오버라이딩
		System.out.println("안녕하세요  " + name + "씨");
	}
}
