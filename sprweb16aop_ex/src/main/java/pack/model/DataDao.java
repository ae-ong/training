package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMapperInterface mapperInterface;
	//전체 직원 자료
	public ArrayList<JikwonDto> jikwonList(){
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) mapperInterface.jikwonList();
		return list;
	}
	
	//고객 로그인
	public GogekDto gogekLogin(String gogek_no) {
		GogekDto dto = (GogekDto)mapperInterface.gogekLogin(gogek_no);
		return dto;
	}
	
	//고객 담당 직원 자료
	public JikwonDto damJikList(String gogek_damsano) {
		JikwonDto dto = (JikwonDto)mapperInterface.damJikList(gogek_damsano);
		return dto;
	}
}
