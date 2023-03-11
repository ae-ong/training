package aop1;

public class LogicImpl implements LogicInter{
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}

	public LogicImpl(ArticleInter articleInter) {
		this.articleInter=articleInter;
	}
	
	public void selectData_process1() {
		System.out.println("selectData_process1 수행");
		articleInter.selectAll();
	}
	
	public void selectData_process2() {
		System.out.println("selectData_process2 처리");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("3초 처리 완료");
	}
}
