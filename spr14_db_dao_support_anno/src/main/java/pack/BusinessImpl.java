package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	@Qualifier("sangpumImpl")
	private SangpumInter sangpumInter;
	
	
	public void dataList() {
		for(SangpumDto s:sangpumInter.selectList()) {
			System.out.println(s.getCode()+" "+s.getSang()+" "+s.getSu()+" "+s.getDan());
		}
	}
}
