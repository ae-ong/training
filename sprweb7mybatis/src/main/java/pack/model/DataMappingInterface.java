package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.FormBean;

@Mapper //mybatis
public interface DataMappingInterface {
	//추상 메소드의 이름은  mapper.xml의 id와 일치시켜야함
	List<SangpumDto> selectAll();
	List<SangpumDto> selectSearch(FormBean bean);
}
