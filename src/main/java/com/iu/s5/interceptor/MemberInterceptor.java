package com.iu.s5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		Object obj = request.getSession().getAttribute("member");
		
		if(obj != null) {
			check = true;
		}else {
			response.sendRedirect("./memberLogin");
		}
		
		return check;
	}
	
	
}
