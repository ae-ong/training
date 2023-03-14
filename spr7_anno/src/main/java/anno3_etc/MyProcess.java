package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	@Value("#{dataInfo.name}")
	private String name;
	private String part;
	
	public MyProcess() {
		// TODO Auto-generated constructor stub
	}
	@Autowired //한개의 생성자에만 사용 가능
	//public MyProcess(@Value("총무부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {  //spEL 사용 #{표현식}
		this.part = part;
	}
	@Value("#{dataInfo.job}")
	private String job;
	
	@Value("30")
	private int age;
	
	@Value("1,2,3,4")
	private int[] arr;
	
	public void showResult() {
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("job : " + job);
		System.out.println("age : " + age);
		System.out.println("arr[0} : " + arr[0]);
	}
}
