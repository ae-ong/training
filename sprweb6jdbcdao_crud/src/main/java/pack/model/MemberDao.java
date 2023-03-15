package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport {
	@Autowired
	public MemberDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}

	// 전체 자료 읽기(SELECT)
	public List<MemberDto> getMemberList() {
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

	//추가
	public void insData(MemberBean bean) {
		String sql = "insert into member values(?,?,?,now())";
		Object[] params = { bean.getId(), bean.getPwd(), bean.getName() };
		getJdbcTemplate().update(sql, params); // JdbcDaoSupport
	}

	//수정 할 레코드 읽기
	public MemberDto getMember(String id) {
		String sql = "select * from member where id=?";
		MemberDto dto = (MemberDto) getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapper() {
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
		return dto;
	}
	//수정
	public void upData(MemberBean bean) {
		String sql = "update member set pwd=?, name=? where id=?";
		getJdbcTemplate().update(sql, new Object[] {bean.getPwd(), bean.getName(), bean.getId()}); // JdbcDaoSupport
	}
	
	//삭제
	public void delData(String id) {
		String sql = "delete from member where id=?";
		getJdbcTemplate().update(sql, new Object[] {id}); // JdbcDaoSupport
	}
}
