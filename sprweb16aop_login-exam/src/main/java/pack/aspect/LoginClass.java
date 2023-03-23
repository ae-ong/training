package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginClass {

	public boolean loginCheck(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("gname") == null) {
			
			try {
				
				response.sendRedirect("login");
				
			} catch (Exception e) {
				System.out.println("sendRedirect error : " + e);
			}
			return true;
			
		}else {
			return false;
		}
		
	}
	
	
}
