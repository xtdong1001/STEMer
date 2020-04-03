package com.xdong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.UserAccount;
import com.xdong.service.IUserAccountService;

@Controller
public class UserAccountController {
	@Autowired
	IUserAccountService userAccountService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		UserAccount userAccount = new UserAccount(request.getParameter("email"), request.getParameter("password"), request.getParameter("accountType"));
		userAccountService.add(userAccount);
		Integer uId = (Integer)userAccountService.validate(userAccount);
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", uId);
		session.setAttribute("accountType", userAccount.getAccountType());
		
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest request, HttpServletResponse response) {
		UserAccount userAccount = new UserAccount(request.getParameter("email"), request.getParameter("password"), request.getParameter("accountType"));
		Integer uId = (Integer)userAccountService.validate(userAccount);
		if(uId == -1) {
			return new ModelAndView("login", "errMsg", "Email or password is incorrect.");
		}
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", uId);
			session.setAttribute("accountType", userAccount.getAccountType());
			return new ModelAndView("welcome");
		}
	}
}
