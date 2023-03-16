package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper //mybatis
public interface DataMappingInterface {
	//추상 메소드의 이름은  mapper.xml의 id와 일치시켜야함
	@Select("select jikwon_no, jikwon_name, buser_name, jikwon_jik, jikwon_ibsail from jikwon INNER JOIN buser ON buser_num=buser_no")
	List<JikwonDto> selectAll();
	@Select("SELECT jikwon_no, jikwon_name, buser_name, jikwon_jik, jikwon_ibsail FROM jikwon INNER JOIN buser ON buser_num=buser_no WHERE buser_name=#{searchValue}")
	List<JikwonDto> selectPart(FormBean bean);
	@Select("select buser_name from buser")
	List<JikwonDto> buserName();
	@Select("select * from buser where buser_name=#{bname}")
	JikwonDto buser(String bname);
}

//DataMappingInterface는 mapper.xml에 있는 sql문을 호출하기 위한 인터페이스
//mybatis 3.0 이후 버전에서 지원
//과거에 sqlsession을 사용하여 selectlist, selectone 등을 지원 받았으나 이런 복잡한 Configuration.xml 만들고 할 것 없이
//@Mapper를 쓰면 메소드 명과 xml파일의 id를 매핑시켜 사용할 수 있다
//mapper.xml이 DataMappingInterface의 하위 객체로 등록되어 id="select어쩌고"를 메소드에서 호출할 수 있다
//그러면 service단에서 autowired가 가능해진다