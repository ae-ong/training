package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.MemBean;

@Mapper
public interface DataMappingInterface { //mybatis annotatio
	@Select("select * from mem")
	List<MemDto> selectAll();
	
	@Select("select * from mem where num=#{num}")
	MemDto selectPart(String num);
	
	@Insert("insert into mem values(#{num}, #{name}, #{addr})")
	int insertData(MemBean bean);
	
	@Update("update mem set name=#{name}, addr=#{addr} where num=#{num}")
	int updateData(MemBean bean);
	
	@Delete("delete from mem where num=#{num}")
	int deleteData(String num);
}
