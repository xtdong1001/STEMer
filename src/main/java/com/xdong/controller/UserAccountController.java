package com.xdong.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.RegisterAccount;
import com.xdong.model.UserAccount;
import com.xdong.service.IUserAccountService;

@Controller
public class UserAccountController {
	
	private static final Logger logger = Logger.getLogger(UserAccountController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView mav = new ModelAndView("register");
		RegisterAccount registerAccount = new RegisterAccount();
		mav.addObject("registerAccount", registerAccount);
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView("login");
		UserAccount userAccount = new UserAccount();
		mav.addObject("userAccount", userAccount);
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		//delete cookies
		for (Cookie cookie : request.getCookies()) {
		    if(cookie.getName().equals("userId") 
		    		|| cookie.getName().equals("accountType") || cookie.getName().equals("Id")) {
		    	cookie.setMaxAge(0);
		    	response.addCookie(cookie);
		    }
		}
		
		if(request.getSession(false) == null || request.getSession(false).getAttribute("userId") == null)
			return new ModelAndView("redirect:/company/index");
		request.getSession(false).invalidate();
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView permissionError(HttpServletRequest request) {
		return new ModelAndView("error", "errMsg", "Sorry, you don't have the permission");
	}
}
