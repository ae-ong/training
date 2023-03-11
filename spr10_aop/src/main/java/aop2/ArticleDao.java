package aop2;

import org.springframework.stereotype.Repository;

@Repository	// db 처리용 클래스임을 명시해줌
public class ArticleDao implements ArticleInter{
	public void selectAll() {
		System.out.println("상품 전체 자료 읽기");
	}
}
