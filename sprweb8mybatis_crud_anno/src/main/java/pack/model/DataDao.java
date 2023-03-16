package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataMappingInterface mappingInterface;
	
	//전체 자료 읽기
	public List<MemDto> getDataAll(){
		List<MemDto> list = mappingInterface.selectAll();
		logger.info("datas : " + list.size());
		return list;
	}
	
	//자료 추가
	public boolean insert(MemBean bean) {
		//번호 중복 및 자동 증가 작업 생략j
		try {
			int re = mappingInterface.insertData(bean);
			if(re>0) {
				return true;				
			}else return false;
		} catch (Exception e) {
			logger.info("insert 실패 : " + e.getMessage());
			return false;
		}
	}
	
	//레코드 한 개 읽기
	public MemDto getData(String num) {
		MemDto dto = mappingInterface.selectPart(num);
		return dto;
	}
	
	//자료 수정
	public boolean update(MemBean bean) {
		try {
			int re = mappingInterface.updateData(bean);
			if(re>0) {
				return true;				
			}else return false;
		} catch (Exception e) {
			logger.info("update 실패 : " + e.getMessage());
			return false;
		}
	}
	
	//자료  삭제
	public boolean delete(String num) {
		try {
			int re = mappingInterface.deleteData(num);
			if(re>0) {
				return true;				
			}else return false;
		} catch (Exception e) {
			logger.info("delete 실패 : " + e.getMessage());
			return false;
		}
	}
}
