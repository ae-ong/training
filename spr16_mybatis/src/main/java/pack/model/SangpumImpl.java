package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter{
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<SangpumDto> selectDataAll() {
		SqlSession session = factory.openSession();
		List<SangpumDto> list = null;
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		}finally {
			if(session != null) session.close();
		}
		return list;
	}
}
