package pack;

public class Message2 implements MessageInter{ //파생 클래스
	public void sayHello(String name) { //추상 메소드 오버라이딩
		System.out.println("반가워요 " + name + "님");
	}
}
