package com.xdong.interceptor;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.UserAccount;

@Component
public class CookiesInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); 
		HashMap<String, String> map = new HashMap<>();
		if(session == null || session.getAttribute("userId") == null) {
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getMaxAge() > 0)
					map.put(cookie.getName(), cookie.getValue());
			}
			if(map.size() == 0)
				return true;
			session.setAttribute("userId", Integer.parseInt(map.get("userId")));
			session.setAttribute("accountType", map.get("accountType"));
			int id = Integer.parseInt(map.get("Id"));
			if(map.get("accountType").equals("company"))
				session.setAttribute("companyId", id);
			else
				session.setAttribute("profileId", id);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
