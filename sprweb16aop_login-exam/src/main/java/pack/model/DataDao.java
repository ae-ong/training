package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMappingInter mappingInter;
	
	public ArrayList<JikwonDto> getJikListAll() {
		ArrayList<JikwonDto> list = mappingInter.getJikListAll();
		return list;
	}
	
	public  ArrayList<JikwonDto> getDamJik(String gogek_no, String gogek_name) {
		ArrayList<JikwonDto> list = mappingInter.getDamJik(gogek_no, gogek_name);
		return list;
	}
	
	public JikwonDto getGogekInfo(String gogek_no) {
		JikwonDto dto = mappingInter.getGogekInfo(gogek_no);
		return dto;
	}
	
}
