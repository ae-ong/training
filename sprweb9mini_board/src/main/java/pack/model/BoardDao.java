package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DataMappingInterface dataMappingInterface;
	
	//전체 자료 읽기
	public List<Board> list(){
		List<Board> list = null;
		try {
			list = dataMappingInterface.selectList();
		} catch (Exception e) {
			logger.info("list err : " + e);
		}
		return list;
	}
	
	//글 입력
	public boolean insertData(BoardBean bean) {
		boolean b = false;
		int re = dataMappingInterface.insert(bean);
		if(re > 0) b = true;
		/*
		try {
			//새글 번호
			String sql = "select max(num) from springboard";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) newNum = rs.getInt(1) + 1;
			
			sql = "insert into springboard(num,author,title,content) values(?,?,?,?)";
			pstmt = conn.preparestatement(sql);
			pstmt.setInt(1, newNum);
			pstmt.setString(2, bean.getAuthor());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getContent());
			if(pstmt.executeUpdate() > 0) b = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		*/
		return b;
	}
	
	//검색
	public List<Board> search(BoardBean bean){
		List<Board> slist = dataMappingInterface.selectSearch(bean);
		return slist;
	}
	
	//상세보기
	public Board detail(String num) {
		dataMappingInterface.updateReadcnt(num); //조회수 증가
		Board board = dataMappingInterface.selectOne(num);
		/*
		try {
			//상세보기 할 때 조회수 증가
			String sql ="update springboard set readcnt=readcnt+1 where num=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
			//레코드 읽기
			sql = "select * from springboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board;
				board.setNum(rs.getInt("num"));
				...
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		*/
		return board;
	}
	
	//수정
	public boolean update(BoardBean bean) {
		boolean b = false;
		int re = dataMappingInterface.update(bean);
		if(re > 0) b = true;
		/*
		try {
			String sql = "update springboard set author=?, title=?, content=? where num=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getAuthor());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setInt(4, bean.getNum());
			if(pstmt.executeUpdate() > 0) b = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		*/
		return b;
	}
	
	//삭제
	public boolean delete(String num) {
		boolean b = false;
		int re = dataMappingInterface.delete(num);
		if(re > 0) b = true;
		/*
		try {
			String sql = "delete from springboard where num=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			if(pstmt.executeUpdate() > 0) b = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		*/
		return b;
	}
}
