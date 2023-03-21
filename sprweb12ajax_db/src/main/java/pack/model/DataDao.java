package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired //auto pulling
	private DataMappingInterface mappingInterface;
	
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = mappingInterface.selectAll();
		return list;
	}
}
