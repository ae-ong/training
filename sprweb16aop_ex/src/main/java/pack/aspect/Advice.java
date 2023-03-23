package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
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
		/*
		if(loginClass.loginCheck(request, response)) {
			return 
		}*/
		
		Object object = joinPoint.proceed();
		
		return object;
	}
}
