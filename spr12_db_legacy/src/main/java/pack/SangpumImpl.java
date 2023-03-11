package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository	// db
public class SangpumImpl implements SangpumInter{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SangpumImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("jdbcDriver err: "+e);
		}
	}
	
	public ArrayList<SangpumDto> selectList() {
		ArrayList<SangpumDto> list=new ArrayList<SangpumDto>();
		try {
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
			pstmt=conn.prepareStatement("select * from sangdata");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SangpumDto dto=new SangpumDto();
				dto.setCode(rs.getString(1));
				dto.setSang(rs.getString(2));
				dto.setSu(rs.getString(3));
				dto.setDan(rs.getString(4));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectList err: "+e);
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
}
