package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDaoImpl {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DataMappingInterface dataInterface;
	
	//전체 자료 읽기
	public List<BoardDto> listAll(){ //mybatis는 두개 이상의 레코드를 반환할때 List사용(ArrayList안됨)
		List<BoardDto> list = dataInterface.selectList();
		logger.info("반환된 레코드 수 : " + list.size());
		return list;
	}
	//검색
	public List<BoardDto> search(BoardBean bean){
		List<BoardDto> list = dataInterface.searchList(bean);
		logger.info("검색된 레코드 수 : " + list.size());
		return list;
	}
	//페이징
	public int totalCnt() {
		return dataInterface.totalCnt();
	}
	
	public boolean insert(BoardBean bean) {
		boolean b = false;
		int re = dataInterface.insertData(bean);
		if(re >= 0) b = true;
		return b;
	}
	
	public int currentNum() {
		//추가 시 num 자동증가를 위해 현재 레코드 중 가장 큰 번호 얻기
		return dataInterface.currentNum();
	}
	
	public void updateReadcnt(String num) {
		//상세보기 전 조회수 증가
		dataInterface.updateReadcnt(num);
	}
	//상세보기
	public BoardDto detail(String num) {
		//글 내용 보기, 수정, 댓글 용
		BoardDto dto = dataInterface.selectOne(num);
		return dto;
	}
	//수정
	public boolean update(BoardBean bean) {
		boolean b = false;
		int re = dataInterface.updateData(bean);
		if(re > 0) b = true;
		return b;
	}
	
	public String selectPass(String num) { //수정 시 비밀번호 비교대상
		return dataInterface.selectPass(num);
	}
	
	public boolean delete(String num) {
		boolean b = false;
		int re = dataInterface.deleteData(num);
		if(re > 0) b = true;
		return b;
	}
	
	//댓글
	public boolean updateOnum(BoardBean bean) {
		//댓글에서 onum 갱신
		boolean b = false;
		int re = dataInterface.updateOnum(bean);
		if(re > 0) b = true;
		return b;
	}
	
	public boolean insertReply(BoardBean bean) {
		boolean b = false;
		int re = dataInterface.insertReData(bean);
		if(re >= 0) b = true;
		return b;
	}
}
