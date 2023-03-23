package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectClass {
	@Autowired
	private SecurityClass securityClass;
	
	@Around("execution(public String processMsg()) or execution(public String businessMsg())") //핵심 메소드 지정
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		securityClass.mySecurity(); //핵심 메소드 수행 전 관심사항 수행
		
		Object object = joinPoint.proceed(); //핵심 메소드 수행
		//Object object = null; 핵심 메소드 수행 안함
		
		System.out.println("핵심 메소드 수행 후 뭔가를 수행");
		
		return object;
	}
}
