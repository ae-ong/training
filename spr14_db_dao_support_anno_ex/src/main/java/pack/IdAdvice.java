package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IdAdvice {
	@Around("execution(public void dataList())")
	public Object login(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.print("id 입력: ");
		Scanner sc=new Scanner(System.in);
		String id=sc.nextLine();
		sc.close();
		
		if(!id.equals("kor")) {
			System.out.println("id 불일치");
			System.out.println("핵심 로직 수행 전 작업 종료");
			return null;
		}
		System.out.println();
		// 핵심 메서드 수행
		Object object=joinPoint.proceed();
		
		return object;
	}
}
