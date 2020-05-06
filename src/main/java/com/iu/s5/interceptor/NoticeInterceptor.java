package com.iu.s5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s5.member.MemberVO;


@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//주소를 쳣을 때  form이 안 나오게
		//controller 진입 전
		
		boolean check=false;
		
		
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		

		
		
		if(memberVO != null && memberVO.getId().equals("admin")) {
			check = true;
			System.out.println("관리자");
		}else {
			System.out.println("관리자 아님");
			//response.sendRedirect("../member/memberLogin");
			//모델앤뷰 못씀
			//서블릿에서 썼던
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("path", "../");
			view.forward(request, response);
		}
		
		
		

		
		return check;
	}
}
