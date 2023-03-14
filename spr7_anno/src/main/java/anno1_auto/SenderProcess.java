package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service("sprocess") 가독성을 위함, service관(business logic) 클래스에게 부여
@Service //서비스를 진행할 객체 생성
@ComponentScan("anno1_auto")
public class SenderProcess {
	//@Autowired 타입에 의한 매핑**
	//@Autowired(required = true) //기본값, 가져오는 클래스의 객체가 있어야함
	//private Sender sender;
	@Autowired //객체를 타입으로 찾는다, 이름으로 찾는게 아님
	@Qualifier("sender2") //같은 타입의 객체가 여러개인 경우 이름 지정
	private SenderInter senderInter; 
	
	/*
	@Autowired
	public SenderProcess(Sender sender) {
		
	}
	*/
	/*
	 @Autowired
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	 @Autowired
	public void setSbs(Sender sender) {
		this.sender = sender;
	}
	*/
	/*
	public Sender getSender() {
		return sender;
	}
	
	public void displayData() {
		sender.show();
	}
	*/
	
	public SenderInter getSenderInter() {
		return senderInter;
	}
	
	public void displayData() {
		senderInter.show();
	}
}
