package com.inc.dayary.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SignInInterceptor extends HandlerInterceptorAdapter{
//내부 로직에 의해서 컨트롤러로 요청을 함(return이 true일때만)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			if(request.getSession().getAttribute("member") == null) {
				response.sendRedirect("/member/signin");
				return false;
			}
		return true;
	}
	
	
}
