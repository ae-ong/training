package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pack.model.SangpumDto;
import pack.model.SangpumInter;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	@Qualifier("sangpumImpl")
	private SangpumInter inter;
	
	public void dataList() {
		List<SangpumDto> list = inter.selectDataAll();
		
		for(SangpumDto s:list) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
		}
	}
}
