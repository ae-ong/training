package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMappingInterface dataInterface;
	
	//부서 자료 읽기
	public ArrayList<BuserDto> buserList(){
		ArrayList<BuserDto> blist = (ArrayList<BuserDto>) dataInterface.buserList();
		return blist;
	}
	
	//직원 자료 읽기
	public ArrayList<JikwonDto> jikwonList(String buser_no){
		ArrayList<JikwonDto> jlist = (ArrayList<JikwonDto>) dataInterface.jikwonList(buser_no);
		return jlist;
	}
}