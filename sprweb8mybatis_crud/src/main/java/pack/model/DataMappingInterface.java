package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.MemBean;

@Mapper
public interface DataMappingInterface {
	List<MemDto> selectAll();
	MemDto selectPart(String num);
	boolean insertData(MemBean bean);
	boolean updateData(MemBean bean);
	boolean deleteData(String num);
}
