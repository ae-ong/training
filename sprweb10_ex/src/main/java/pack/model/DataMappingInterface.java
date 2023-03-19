package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //mybatis
public interface DataMappingInterface {
	//추상 메소드의 이름은  mapper.xml의 id와 일치시켜야함
	@Select("select jikwon_no, jikwon_name, buser_name, jikwon_jik, if(jikwon_no IN (SELECT DISTINCT(gogek_damsano) FROM gogek), 'O','X') as jikwon_dam "
			+ "from jikwon INNER JOIN buser ON buser_num=buser_no")
	List<JikwonDto> selectAll();
	@Select("select gogek_no, gogek_name, case "
			+ "when SUBSTR(gogek_jumin, 8, 1) < 3 then DATE_FORMAT(NOW(), '%Y') - (SUBSTR(gogek_jumin, 1, 2) + 1900) "
			+ "ELSE DATE_FORMAT(NOW(), '%Y') - (SUBSTR(gogek_jumin, 1, 2) + 2000) "
			+ "END AS gogek_nai, case SUBSTR(gogek_jumin, 8,1)  "
			+ "when 1 then '남' "
			+ "when 2 then '여' "
			+ "END AS gogek_gen, gogek_tel from gogek where gogek_damsano=(select jikwon_no from jikwon where jikwon_no=#{searchValue})")
	List<GogekDto> selectGogek(String no);
}

//DataMappingInterface는 mapper.xml에 있는 sql문을 호출하기 위한 인터페이스
//mybatis 3.0 이후 버전에서 지원
//과거에 sqlsession을 사용하여 selectlist, selectone 등을 지원 받았으나 이런 복잡한 Configuration.xml 만들고 할 것 없이
//@Mapper를 쓰면 메소드 명과 xml파일의 id를 매핑시켜 사용할 수 있다
//mapper.xml이 DataMappingInterface의 하위 객체로 등록되어 id="select어쩌고"를 메소드에서 호출할 수 있다
//그러면 service단에서 autowired가 가능해진다