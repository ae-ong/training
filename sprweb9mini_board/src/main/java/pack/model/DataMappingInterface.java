package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pack.controller.BoardBean;

@Mapper
public interface DataMappingInterface {
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	
	int insert(BoardBean bean);
	int update(BoardBean bean);
	void updateReadcnt(String num);
	int delete(String num);
}
