package aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ProfileAdvice {	// Advice 용
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("핵심 메서드 전 뭔가를 처리");
		StopWatch stopWatch=new StopWatch();	// framework에서 제공 ... 처리 소요 시간을 구할 수 있도록 spring이 지원
		stopWatch.start();
		
		Object object=joinPoint.proceed();	// 핵심 로직 수행
		
		System.out.println("핵심 메서드 후 뭔가를 수행");
		stopWatch.stop();
		System.out.println("처리 소요 시간: "+stopWatch.getTotalTimeSeconds());
		
		return object;
	}
}
