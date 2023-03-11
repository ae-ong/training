package pack;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	// Advice(Aspect-관심사항을 클래스로 구현)로 사용할 클래스: joinpoint(sayHi())에 삽입되어 동작할 코드
	// advice를 target클래스의 임의의 메서드에 추가...interceptor 하는 것
	
	// MethodInterceptor는 자동으로 Around Advice 지원
	// Object를 반환한다는 것이 중요
	// invoke: 시스템에서 자동 호출된 것(callback)...implements MethodInterceptor
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// joinpoint에 삽입되어 동작할 코드 기술
		
		// target 메서드 이름 얻기
		String methodName=invocation.getMethod().getName();
		// Around Advice 사용 (핵심로직 앞뒤로 수행)
		System.out.println("핵심로직 수행 전 관심사항: 호출될 target 메서드 이름: "+methodName);
		
		Object object=invocation.proceed();	// 핵심로직 수행 - ex) sayHi // 얘가 기준 (Around/Before/After) 
		
		System.out.println("핵심로직 수행 후 관심사항 - 뭔가를 처리");
		
		return object;
	}
}
