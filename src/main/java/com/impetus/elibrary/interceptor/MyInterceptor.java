package com.impetus.elibrary.interceptor;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger(MyInterceptor.class.getName());
    
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        logger.info("Request URL::" + request.getRequestURL().toString() + 
                ":: Start Time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        //if returned false, we need to make sure 'response' is sent
        return true;
    }
}
