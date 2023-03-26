package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pack.controller.FormBean;

@Repository
@Slf4j
public class DataProcess {
	@Autowired
	private DataMappingInterface dataMappingInterface;
	
	public List<DataDto> getDataAll(){
		List<DataDto> list = dataMappingInterface.selectAll();
		log.info("datas : " + list.size()); //loggerfactory를 쉽게 사용(slf4j)
		return list;
	}
	
	public List<DataDto> getDataSearch(FormBean bean){
		List<DataDto> slist = dataMappingInterface.selectSearch(bean);
		log.info("datas : " + slist.size());
		return slist;
	}
}
