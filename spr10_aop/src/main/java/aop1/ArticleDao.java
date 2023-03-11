package aop1;

public class ArticleDao implements ArticleInter{
	public void selectAll() {
		System.out.println("상품 전체 자료 읽기");
	}
}
