package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter{
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<JikwonDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		try {
			list = sqlSession.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectDataAll err : "  + e);
		}finally{
			sqlSession.close();
		}
		return list;
	}
	
	public List<JikwonDto> maxPay() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> payList = null;
		try {
			payList = sqlSession.selectList("maxPay");
		} catch (Exception e) {
			System.out.println("maxPay err : "  + e);
		}finally{
			sqlSession.close();
		}
		return payList;
	}
}
