package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.FormBean;

@Repository
public class DataDao {
	//private Logger logger = LoggerFactory.getLogger(DataDao.class);
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataMappingInterface mappingInterface; //자동 풀링
	
	public List<JikwonDto> getDataAll(){
		List<JikwonDto> list = mappingInterface.selectAll();
		return list;
	}
	
	public List<JikwonDto> getDataSearch(FormBean bean){
		List<JikwonDto> slist = mappingInterface.selectPart(bean);
		return slist;
	}
	
	public List<JikwonDto> getBuserName(){
		List<JikwonDto> blist = mappingInterface.buserName();
		return blist;
	}
	
	public JikwonDto getBuser(String bname){
		JikwonDto ilist = mappingInterface.buser(bname);
		return ilist;
	}
}
