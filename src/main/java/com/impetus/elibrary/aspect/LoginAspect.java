package com.impetus.elibrary.aspect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.impetus.elibrary.controller.BookControllerGet;
import com.impetus.elibrary.controller.LoginController;

@Aspect
public class LoginAspect {

    @Around("execution(* com.impetus.elibrary.controller.*.*(..))")
    public Object logBefore(ProceedingJoinPoint joinPoint) {
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
        Object response = null;

        boolean bypass = checkBypass(joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        if (bypass) {
            try {
                System.out.println("bypassing... ");
                // continue on the intercepted method
                response = joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return response;
        }

        HttpSession session = (HttpSession) RequestContextHolder.currentRequestAttributes().resolveReference(
                RequestAttributes.REFERENCE_SESSION);
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.currentRequestAttributes().resolveReference(
                RequestAttributes.REFERENCE_REQUEST);
         

        if (session == null || session.getAttribute("loggedin_user") == null) {
            try {
                System.out.println("route to logout page....");
                request.setAttribute("errorMsg", "Invalid session... Please login again.");
                request.getRequestDispatcher("lib_login").forward(request, null);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            ModelAndView loginMAV = new ModelAndView("lib_login");
            loginMAV.addObject("errorMsg","");
            response = loginMAV;
        } else {
            try {
                System.out.println("invoking controller... ");
                // continue on the intercepted method
                response = joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private boolean checkBypass(String clazz, String method) {

        System.out.println("checking... " + clazz + "." + method + "()");
        boolean result = false;
        if (LoginController.class.getName().equals(clazz)) {
            result = true;
        } else if (BookControllerGet.class.getName().equals(clazz)) {
            result = true;
        }

        if (result) {
            System.out.println("bypassing... " + clazz + "." + method + "()");
        }
        return result;
    }
}
