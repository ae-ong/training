package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.SqlMapperInter;

@Service
public class ProcessImpl implements ProcessInter{
	@Autowired
	private SqlMapperInter inter;
	
	public void dataShow() {
		List<JikwonDto> listJikwon = inter.selectDataAll();
		List<JikwonDto> listPay = inter.maxPay();
		
		//부서별 인원수
		int chongmu = 0;
		int kwanri = 0;
		int jeonsan = 0;
		int youngup = 0;
		int etc = 0;
		System.out.println("사번\t이름\t부서명\t입사년");
		for(JikwonDto jik:listJikwon) {
			System.out.println(jik.getJikwon_no() + "\t" + jik.getJikwon_name() + "\t" + jik.getBuser_name() + "\t" + jik.getJikwon_year());
			if(jik.getBuser_name().equals("총무부")) {
				chongmu += 1;
			}else if(jik.getBuser_name().equals("관리부")) {
				kwanri += 1;
			}else if(jik.getBuser_name().equals("전산부")) {
				jeonsan += 1;
			}else if(jik.getBuser_name().equals("영업부")) {
				youngup += 1;
			}else if(jik.getBuser_name().equals("무소속")) {
				etc += 1;
			}
		}
		System.out.println("\n부서별 인원수");
		System.out.println("총무부  : " + chongmu);
		System.out.println("관리부  : " + kwanri);
		System.out.println("전산부  : " + jeonsan);
		System.out.println("영업부  : " + youngup);
		System.out.println("무소속  : " + etc);
		
		System.out.println("\n부서별 최고 연봉자");
		for(JikwonDto pay:listPay) {
			System.out.println(pay.getBuser_name() + " : " + pay.getJikwon_name() + "(" + pay.getJikwon_pay() + ")");
		}
	}
}
