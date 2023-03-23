package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("select jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel, jikwon_gen "
			+ "from jikwon left outer join buser on jikwon.buser_num= buser.buser_no")
	List<JikwonDto> jikwonList();
	
	@Select("select gogek_no, gogek_name, gogek_damsano from gogek where gogek_no=#{param1}")
	GogekDto gogekLogin(String gogek_no);
	
	@Select("select jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel, jikwon_gen "
			+ "from jikwon inner join buser on jikwon.buser_num=buser.buser_no where jikwon_no="
			+ "(select gogek_damsano from gogek where gogek_no=#{param1})")
	JikwonDto damJikList(String gogek_no);
	
}
