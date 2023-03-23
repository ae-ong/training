package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMappingInterface dataInterface;
	
	//직원 자료 읽기
	public ArrayList<JikwonDto> jikwonList(){
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) dataInterface.jikwonList();
		return list;
	}
	
	//직원 로그인
	public JikwonDto jikwonLogin(String jikwon_no) {
		JikwonDto dto = (JikwonDto)dataInterface.jikwonLogin(jikwon_no);
		return dto;
	}

}
