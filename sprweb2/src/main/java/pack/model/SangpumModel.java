package pack.model;

import org.springframework.stereotype.Service;

@Service // businees logic 담당
public class SangpumModel {
	public String compute(SangpumBean bean) {
		String data = "품명 : " + bean.getSang() + " , 금액 : " + bean.getSu() * bean.getDan();
		return data;
	}
}
