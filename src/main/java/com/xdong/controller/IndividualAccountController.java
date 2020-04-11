package com.xdong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Application;
import com.xdong.model.IndividualAccount;
import com.xdong.model.UserAccount;
import com.xdong.service.IGenericService;
import com.xdong.service.IUserAccountService;
import com.xdong.service.IndividualAccountService;

@Controller
public class IndividualAccountController {
	@Autowired
	IGenericService<IndividualAccount> individualAccountService;
	
	@Autowired
	IUserAccountService<UserAccount> userAccountService;
	
	@RequestMapping(value = "/user/applications", method = RequestMethod.GET)
	public ModelAndView getUserApplications(HttpServletRequest request) {
		if(request.getSession(false) == null || request.getSession(false).getAttribute("userId") == null)
			return new ModelAndView("login");
		List applications = individualAccountService.getById((int)request.getSession(false).getAttribute("userId")).getApplications();
		ModelAndView mav = new ModelAndView("applications_user");
		mav.addObject("applications", applications);
		return mav;
	}
	
	@RequestMapping(value = "/individual/loginProcess", method = RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result,  HttpServletRequest request, HttpServletResponse response) {
		userAccountService.validate(userAccount, result);
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("userAccount", userAccount);
			return mav;
		}

		Integer uId = (Integer)userAccountService.check(userAccount);
		if(uId == -1) {
			return new ModelAndView("login", "errMsg", "Email, password or account type is incorrect.");
		}
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", uId);
			session.setAttribute("accountType", userAccount.getAccountType());
			System.out.println(userAccount.getAccountType());
			return new ModelAndView("welcome");
		}
	}
	
	@RequestMapping(value = "/individual/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, HttpServletRequest request) {
		/*
		 * userAccountService.validate(userAccount, result); if(result.hasErrors()) {
		 * ModelAndView mav = new ModelAndView("register"); mav.addObject("userAccount",
		 * new UserAccount()); return mav; }
		 */
		
		if(userAccountService.checkEmailExist(userAccount.getEmail()) != -1) {
			return new ModelAndView("register", "errMsg", "Email is already used.");
		}
		
		individualAccountService.add(new IndividualAccount(userAccount));
		
		int uId = userAccountService.checkEmailExist(userAccount.getEmail());
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", uId);
		session.setAttribute("accountType", userAccount.getAccountType());

		return new ModelAndView("welcome");
	}
	 
}