package pack.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInter {

	@Select("SELECT jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel, jikwon_gen FROM jikwon"
			+ " LEFT OUTER JOIN buser ON buser_num = buser_no"
			+ " LEFT OUTER JOIN gogek ON jikwon_no = gogek_damsano")
	ArrayList<JikwonDto> getJikListAll();
	
	@Select("SELECT jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel, jikwon_gen FROM jikwon"
			+ " LEFT OUTER JOIN buser ON buser_num = buser_no"
			+ " LEFT OUTER JOIN gogek ON jikwon_no = gogek_damsano"
			+ " WHERE gogek_no = #{param1} AND gogek_name = #{param2}")
	ArrayList<JikwonDto> getDamJik(String param1, String param2);
	
	@Select("select gogek_no, gogek_name from gogek where gogek_no = #{param1}")
	JikwonDto getGogekInfo(String param1);
}
