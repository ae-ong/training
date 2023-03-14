package pack;

import other.OutFileInter;

public class MessageImpl implements MessageInter{
	private String name1, name2; //생성자 주입
	private int year;
	//private MyInfo myInfo;
	private MyInter myInter;
	
	private String spec; //setter 주입
	private OutFileInter fileInter;
	
	public MessageImpl(String name1, String name2, int year, MyInter myInter) {
		this.name1 = name1;
		this.name2 = name2;
		this.year = year;
		this.myInter = myInter;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	public void sayHi() {
		//출력 담당
		String msg = name1 + " " + name2 + "\n" + (year + 23) + "년" + " " +  myInter.myData();
		msg += "\n" + spec;
		
		System.out.println(msg);
		
		//msg를 파일로 출력
		fileInter.outFile(msg);
	}
}
