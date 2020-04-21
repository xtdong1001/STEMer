package com.xdong.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.business.EmailSend;
import com.xdong.model.Application;
import com.xdong.model.UserAccount;
import com.xdong.service.IGenericService;
import com.xdong.validator.ApplicationValidator;
import com.xdong.service.IApplicationService;

@Controller
public class ApplicationController {
	
	private static final Logger logger = Logger.getLogger(ApplicationController.class);

	@Autowired
	IApplicationService<Application> applicationService;
	
	public static final String archivePath = "D:/xtdong/grad/6250 Web dev tools/Archive";

	@RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id, HttpServletRequest request) {
		Application application = applicationService.getById(id);
//
//		if(request.getSession(false).getAttribute("userId") != application.getUserAccount().getUserId())
//			return new ModelAndView("redirect:/error");
		
		ModelAndView mav = new ModelAndView("applicationDetailed_user");
		mav.addObject("application", application);
		return mav;
	}

	@RequestMapping(value = "/apply/{positionId}", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request, @PathVariable("positionId") int positionId) {
		ModelAndView mav = new ModelAndView("apply");
		Application application = new Application();
		mav.addObject("application", application);
		mav.addObject("positionId",positionId);
		return mav;
	}

	@RequestMapping(value = "/application/submit", method = RequestMethod.POST)
	public ModelAndView handleForm(@ModelAttribute("application") Application application, BindingResult result, HttpServletRequest request) {
		applicationService.validate(application, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("apply");
			mav.addObject("application", application);
			mav.addObject("positionId", application.getPosition().getPositionId());
			return mav;
		}
			 
		application.setApplyTime(new Date());
		application.setStatus("Pending");
		
		CommonsMultipartFile resume = application.getResume();
		String filename = resume.getOriginalFilename();
		filename = FilenameUtils.removeExtension(filename) 
				+ "_" + request.getSession(false).getAttribute("userId")
				+ "_" + Calendar.getInstance().getTimeInMillis() 
				+ "." + FilenameUtils.getExtension(filename);
		application.setResumePath(filename);
		File file = new File(archivePath, filename);
		try {
			resume.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			logger.error(e.getStackTrace());
			return new ModelAndView("error");
		}
		
		applicationService.saveOrUpdate(application);

		return new ModelAndView("redirect:/user/applications");
	}
	
	@RequestMapping(value = "/company/application/{id}", method = RequestMethod.GET)
	public ModelAndView getCompanySide(@PathVariable("id") int id, HttpServletRequest request) {
		
		Application application = applicationService.getById(id);
		if(request.getSession(false) == null || request.getSession(false).getAttribute("userId") == null) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("userAccount", new UserAccount());
			return mav;
		}
//		else if(request.getSession(false).getAttribute("userId") != application.getUserAccount().getUserId())
//			return new ModelAndView("error");
		ModelAndView mav = new ModelAndView("applicationDetailed_company");
		mav.addObject("application", application);
		return mav;
	}
	
	@RequestMapping(value = "/company/schedule/{id}", method = RequestMethod.POST)
	public ModelAndView schedule(@PathVariable("id") int id, HttpServletRequest request) {
		Application application = applicationService.getById(id);
		application.setStatus("Decided");
		application.setResult("Interview Scheduled");
		application.setInterviewLocation(request.getParameter("interviewLocation"));
		application.setComments(request.getParameter("comments"));
		SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
		try {
			application.setInterviewTime(fmt.parse(request.getParameter("interviewTime")));
		} catch (ParseException e) {
			logger.error(e.getStackTrace());
		}
		
		applicationService.saveOrUpdate(application);

		EmailSend.send("mailNotify@STEMer.com", application.getEmail(), "Notification from: STEMer - Your application status has been updated!", "Notification from: STEMer\nYour application status has been updated!");
		logger.info("Sent email to "+ application.getEmail());
		
		return new ModelAndView("redirect:/company/application/"+application.getApplicationId());
	}
	
	@RequestMapping(value = "/company/reject/{id}", method = RequestMethod.POST)
	public ModelAndView reject(@PathVariable("id") int id, HttpServletRequest request) {
		Application application = applicationService.getById(id);
		application.setStatus("Decided");
		application.setResult("Rejected");
		application.setComments(request.getParameter("comments"));
		applicationService.saveOrUpdate(application);
		
		EmailSend.send("mailNotify@STEMer.com", application.getEmail(), "Notification from: STEMer - Your application status has been updated!", "Notification from: STEMer\nYour application status has been updated!");
		logger.info("Sent email to "+ application.getEmail());
		return new ModelAndView("redirect:/company/application/"+application.getApplicationId());
	}

}
