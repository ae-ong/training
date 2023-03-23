package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInterface {
	@Select("select jikwon_no, jikwon_name, jikwon_jik, jikwon_gen, buser_name "
			+ "from jikwon left outer join buser on jikwon.buser_num=buser.buser_no")
	List<JikwonDto> jikwonList();
	
	@Select("select jikwon_no, jikwon_name from jikwon where jikwon_no=#{param1}")
	JikwonDto jikwonLogin(String jikwon_no);
}
