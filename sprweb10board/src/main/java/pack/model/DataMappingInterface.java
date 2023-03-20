package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMappingInterface {
	List<BoardDto> selectList();
	List<BoardDto> searchList(BoardBean bean);
	BoardDto selectOne(String num);
	
	int insertData(BoardBean bean);
	int updateData(BoardBean bean);
	int deleteData(String num);
	
	int updateReadcnt(String num);
	int currentNum();
	int totalCnt();
	String selectPass(String num);
	
	int updateOnum(BoardBean bean);
	int insertReData(BoardBean bean);
}
