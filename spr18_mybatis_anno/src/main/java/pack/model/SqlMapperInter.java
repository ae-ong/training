package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SqlMapperInter {
	
	@Select("select jikwon_no, jikwon_name, ifnull(buser_name, '무소속') as buser_name,\r\n"
			+ "		substr(jikwon_ibsail, 1, 4) as jikwon_year\r\n"
			+ "		from jikwon left outer join buser on jikwon.buser_num = buser.buser_no")
	List<JikwonDto> selectDataAll();
	
	@Select("select ifnull((select buser_name from buser where buser_num=buser_no),\r\n"
			+ "		'무소속') as buser_name, jikwon_name, jikwon_pay\r\n"
			+ "		from jikwon a where a.jikwon_pay=(select max(b.jikwon_pay) from jikwon b\r\n"
			+ "		where a.buser_num=b.buser_num) order by buser_num")
	List<JikwonDto> maxPay();
}
