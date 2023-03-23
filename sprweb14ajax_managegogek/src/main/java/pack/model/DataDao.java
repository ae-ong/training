package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

	@Autowired
	private DataMappingInterface mappingInterface;
	
	public JikwonDto jikwon(String gogek_no, String gogek_name) {
		JikwonDto jik = mappingInterface.jikwonData(gogek_no, gogek_name);
		return jik;
	}
}
