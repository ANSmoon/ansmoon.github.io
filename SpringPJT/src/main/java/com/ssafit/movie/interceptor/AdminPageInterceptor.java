package com.ssafit.movie.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminPageInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에서 loginUser 라고 하는 사람의 정보가 admin과 동일하다면...
		HttpSession session = request.getSession();
		if (!"admin".equals(session.getAttribute("loginUser"))) {
			response.sendRedirect("list");
			return false;
		}

		return true; // 통과
	}
}
