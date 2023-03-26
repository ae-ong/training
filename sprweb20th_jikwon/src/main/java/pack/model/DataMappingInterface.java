package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMappingInterface {
	@Select("select jikwon_no, jikwon_name, jikwon_jik, jikwon_pay from jikwon")
	List<DataDto> selectAll();
	@Select("select jikwon_no, jikwon_name, jikwon_jik, jikwon_pay from jikwon "
			+ "where jikwon_name like concat('%', #{searchValue}, '%')")
	List<DataDto> selectSearch(FormBean searchValue);
}
