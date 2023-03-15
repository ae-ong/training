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
	
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = mappingInterface.selectAll();
		logger.info("datas : " + list.size() + " 개");
		return list;
	}
	
	public List<SangpumDto> getDataSearch(FormBean bean){
		List<SangpumDto> slist = mappingInterface.selectSearch(bean);
		logger.info("datas : " + slist.size() + " 개");
		return slist;
	}
}
