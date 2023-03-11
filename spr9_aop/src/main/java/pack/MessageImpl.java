package pack;

public class MessageImpl implements MessageInter{
	// 핵심 로직 클래스..AOP: Target(weaving 대상)
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHi() {
		System.out.println("안녕 "+name+"님 ! 비즈니스 로직 처리 중");
		// 시간 끌기 코드 ( 현재 메서드는 많은 로직을 수행하느라 시간이 걸린다고 가정하고 지연 시간을 부여
		int t=0;
		while(t<5) {	
			try {
				Thread.sleep(1000);	// 1초
				System.out.print(".");
				t++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("\nsayHi 처리 완료");
		System.out.println();
	}
}
