package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInterface {
	@Select("select * from sangdata")
	List<SangpumDto> selectAll();
}
