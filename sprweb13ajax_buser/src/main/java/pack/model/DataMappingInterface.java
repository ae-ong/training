package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInterface {
	@Select("select * from buser")
	List<BuserDto> buserList();
	
	@Select("select jikwon_no, jikwon_name, jikwon_jik from jikwon where buser_num=#{buser_no}")
	List<JikwonDto> jikwonList(String buser_no);
}
