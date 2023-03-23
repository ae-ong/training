package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect //관심 사항(로그인)
public class MyAdvice {
	@Autowired
	private LoginClass loginClass;
	
	@Around("execution(* jikwonProcess*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		for(Object obj:joinPoint.getArgs()) {
			if(obj instanceof HttpServletRequest) {
				request = (HttpServletRequest) obj;
			}
			if(obj instanceof HttpServletResponse) {
				response = (HttpServletResponse) obj;
			}
		}
		
		if(loginClass.loginCheck(request, response)) { //트루이면 로그인 안 한 것 
			return null; //세션이 없으므로 널 반환하도록 해서 핵심 메소드를 수행하지 않음
		}		
		Object object = joinPoint.proceed();
		
		return object;
	}
}
