package pack.controller;

import pack.model.DataDao;

//Spring의 DI(Dependency Injection, 의존성 주입 - 객체를 외부의 조립기(Spring)가 생성 후 특정 클래스에 주입 )
//시스템에 있는 각 객체를 조정하는 외부 객체(Spring)가 의존관계로 주어짐
//느슨한 결합(약결합)이 강점 -> 탈부착이 간편
public class SelectServiceImpl implements SelectService{ //DB처리, 포함관계 사용, 상속 사용 안함
	private DataDao dataDao; //DAO Data Access Object 데이터 접근 객체 인터페이스 변수 선언
	
	public SelectServiceImpl() {}
	
	public SelectServiceImpl(DataDao dataDao) { //생성자 인수로 DataDto(인터페이스)타입 매개변수를 받음
		//생성자 주입(Constructor Injection)
		System.out.println("selectServiceImpl 생성자");
		this.dataDao = dataDao; //setter
	}
	
	public void selectProcess() {
		System.out.println("selectProcess가 DB처리를 위해 dataDao의 파생클래스를 사용");
		dataDao.selectData(); //dataDao 파생클래스의 메소드를 불러옴
	}
}
