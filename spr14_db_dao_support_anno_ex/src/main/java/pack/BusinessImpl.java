package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	@Qualifier("jikwonImpl")
	private JikwonInter jikwonInter;
	
	public void dataList() {
		System.out.println("직원번호"+"\t"+"직원명"+"\t"+"부서명"+"\t"+"직급"+"\t");
		for(JikwonDto j:jikwonInter.selectList()) {
			System.out.println(j.getJikwon_no()+"\t"+j.getJikwon_name()+"\t"+j.getBuser_name()+"\t"+j.getJikwon_jik());
		}
		
		System.out.println("건수: "+jikwonInter.selectList().size());
		
	}
}
