package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	
	@Autowired	// 생성자에 autowired
	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List<SangpumDto> selectList() {
		RowMapper rowMapper = new SangpumRowMapper();
		
		return getJdbcTemplate().query("select * from sangdata", rowMapper);	// JdbcDaoSupport가가지고 있음
		// getJdbcTemplate() 얘를 불러야 sql을 사용할 수 있음
	}
	
	// 내부 클래스
	class SangpumRowMapper implements RowMapper{	// 한 행씩 넘겨받음
		// override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// mapRow: select 실행결과를 한 레코드 씩 전달 받음. 내부적으로 rs.next()가 수행
			// 인덱싱이 자동적으로 되는지 확인하기 위함
			//System.out.println("rowNum: "+rowNum);
			SangpumDto dto=new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
	
	
}
