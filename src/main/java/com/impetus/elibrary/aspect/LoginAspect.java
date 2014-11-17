package com.impetus.elibrary.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.impetus.elibrary.controller.BookControllerGet;
import com.impetus.elibrary.controller.LoginController;

@Aspect
public class LoginAspect {
	
	@Before("execution(* com.impetus.elibrary.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() is running!");
		
		boolean bypass = checkBypass(joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
		if(bypass){
			System.out.println("bypassing... ");
			return;
		}
		
		HttpSession session = (HttpSession) RequestContextHolder.
				currentRequestAttributes().
				resolveReference(RequestAttributes.REFERENCE_SESSION);
		
		if(session == null 
				|| session.getAttribute("loggedin_user") == null){
			System.out.println("route to logout page....");
		}
		
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	private boolean checkBypass(String clazz, String method) {
		
		System.out.println("checking... "+clazz+"."+method+"()");
		boolean result = false;
		if(LoginController.class.getName().equals(clazz)){
			result = true;
		} else if (BookControllerGet.class.getName().equals(clazz)) {
			result = true;
		}
		
		if(result){
			System.out.println("bypassing... "+clazz+"."+method+"()");
		}
		return result;
	}
}
