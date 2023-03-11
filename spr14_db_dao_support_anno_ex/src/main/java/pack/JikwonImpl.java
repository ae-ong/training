package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter{
	
	@Autowired
	public JikwonImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List<JikwonDto> selectList() {
		RowMapper mapper = new JikwonRowMapper();
		String sql="select jikwon_no, jikwon_name, buser_name, jikwon_jik from jikwon join buser on buser_num=buser_no";
		return getJdbcTemplate().query(sql, mapper);
	}
	
	// 내부 클래스
	class JikwonRowMapper implements RowMapper{
		
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			JikwonDto dto=new JikwonDto();
			dto.setJikwon_no(rs.getString("jikwon_no"));
			dto.setJikwon_name(rs.getString("jikwon_name"));
			dto.setBuser_name(rs.getString("buser_name"));
			dto.setJikwon_jik(rs.getString("jikwon_jik"));
			
			return dto;
		}
	}
}
