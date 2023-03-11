package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RunAdvice {
	@Around("execution(public void startProcess())")
	public Object abcd(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println();
		
		// 키보드로 값 받기
		System.out.print("input id: ");
		Scanner sc=new Scanner(System.in);
		String id=sc.nextLine();
		sc.close();
		
		// 로그인에 실패한 경우
		if(!id.equals("aa")) {
			System.out.println("id 불일치. 핵심 로직 수행을 못하고 작업을 종료합니다.");
			return null;	// Object를 반환하는데 얘가 null을 가지고 있으면 핵심 로직을 수행하지 못함
		}
		
		Object object = joinPoint.proceed();	// 핵심 메서드 수행
		
		System.out.println("AOP 종료");
		return object;
	}
}
