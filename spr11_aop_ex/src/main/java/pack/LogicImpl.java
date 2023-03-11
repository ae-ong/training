package pack;

import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void startProcess() {
		System.out.println("검증이 됐으므로 핵심로직 수행");
	}
}
