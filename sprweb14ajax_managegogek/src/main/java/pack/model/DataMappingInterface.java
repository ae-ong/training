package pack.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInterface {
	@Select("SELECT distinct jikwon_name, jikwon_jik, buser_name, buser_tel FROM jikwon, buser, gogek WHERE buser_no = buser_num AND jikwon_no = gogek_damsano AND jikwon_no =\r\n"
			+ " (SELECT gogek_damsano FROM gogek WHERE gogek_no = #{param1} AND gogek_name=#{param2})")
	JikwonDto jikwonData(String gogek_no,String gogek_name);
}

//https://csy7792.tistory.com/302
//@Select("SELECT jikwon_name, jikwon_jik, buser_name, buser_tel FROM jikwon"
//		+ " LEFT OUTER JOIN buser ON buser_num = buser_no" 
//		+ " LEFT OUTER JOIN gogek ON jikwon_no = gogek_damsano"
//		+ " WHERE gogek_no = #{param1} AND gogek_name = #{param2}")
//ArrayList<JikwonDto> getDamJikList(String gogek_no, String gogek_name);