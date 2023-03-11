package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired	
	private SangpumInter sangpumInter;
	
	public void dataList() {
		ArrayList<SangpumDto> dlist=sangpumInter.selectList();
		
		for(SangpumDto s:dlist) {
			System.out.println(s.getCode()+" "+s.getSang()+" "+s.getSu()+" "+s.getDan());
		}
	}
	
}