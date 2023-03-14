package pack.model;

import org.springframework.stereotype.Service;

@Service
public class ScoreModel {
	public String compute(ScoreBean bean) {
		String data = bean.getName() + "님의 총점은 " + (bean.getJava() + bean.getPy()) + ", 평균은 " + (bean.getJava() + bean.getPy())/2;
		return data;
	}
}
