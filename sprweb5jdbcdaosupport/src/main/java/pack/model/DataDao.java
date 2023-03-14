package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport{ //Data Access Object
	@Autowired
	public DataDao(MyDataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public List<SangpumDto> getDataAll(){
		String sql = "select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper());
	}
	
	//내부 클래스
	class ItemRowMapper implements RowMapper<Object>{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}
