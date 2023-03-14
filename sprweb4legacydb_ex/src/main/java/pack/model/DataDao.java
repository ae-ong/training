package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private MyDataSource dataSource;
	
	public ArrayList<GogekDto> getDataAll(){
		ArrayList<GogekDto> list = new ArrayList<GogekDto>();
		try {
			String sql = "select * from gogek";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GogekDto dto = new GogekDto();
				dto.setGogek_no(rs.getString("gogek_no"));
				dto.setGogek_name(rs.getString("gogek_name"));
				dto.setGogek_tel(rs.getString("gogek_tel"));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public ArrayList<JikwonDto> getJikwon(String gogek_no){
		ArrayList<JikwonDto> list1 = new ArrayList<JikwonDto>();
		try {
			String sql = "SELECT jikwon_no, jikwon_name, buser_name, jikwon_jik "
					+ "FROM jikwon INNER JOIN buser ON buser_num=buser_no "
					+ "WHERE jikwon_no=(select gogek_damsano from gogek where gogek_no=?)";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gogek_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JikwonDto dto = new JikwonDto();
				dto.setJikwon_no(rs.getString("jikwon_no"));
				dto.setJikwon_name(rs.getString("jikwon_name"));
				dto.setBuser_name(rs.getString("buser_name"));
				dto.setJikwon_jik(rs.getString("jikwon_jik"));
				list1.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list1;
	}

}
