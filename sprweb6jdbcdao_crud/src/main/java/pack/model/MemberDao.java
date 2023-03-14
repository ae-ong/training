package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends JdbcDaoSupport {
	@Autowired
	public MemberDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	//전체 자료 읽기
	public List<MemberDto> getMemberList(){
		String sql = "select * from member";
		
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				return dto;
			}
		});
		return list;
	}
}
