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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Application;
import com.xdong.model.UserAccount;
import com.xdong.service.IGenericService;
import com.xdong.validator.ApplicationValidator;
import com.xdong.service.IApplicationService;

@Controller
public class ApplicationController {

	@Autowired
	IApplicationService<Application> applicationService;
	
	private static final int MAXPOSITION_USER = 12;
	public static final String archivePath = "D:/xtdong/grad/6250 Web dev tools/Archive";

	/*
	 * @RequestMapping(value = "/list", method = RequestMethod.GET) public
	 * ModelAndView list() { ModelAndView model = new
	 * ModelAndView("application/list"); List list = applicationService.getAll();
	 * model.addObject("list", list);
	 * 
	 * return model; }
	 * 
	 * @RequestMapping(value = "/list/{page}", method = RequestMethod.GET) public
	 * ModelAndView listLimit(@PathVariable("page") int page) { List applications =
	 * applicationService.getAllLimit((page-1)*MAXPOSITION_USER, MAXPOSITION_USER);
	 * int maxpages =
	 * (int)Math.ceil((double)applicationService.getCount()/MAXPOSITION_USER);
	 * 
	 * ModelAndView model = new ModelAndView("applications_user");
	 * model.addObject("applications", applications); model.addObject("pages",
	 * maxpages); model.addObject("currentPage", page); return model; }
	 */
	
	@RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id, HttpServletRequest request) {
		Application application = applicationService.getById(id);

		if(request.getSession(false).getAttribute("userId") != application.getUserAccount().getUserId())
			return new ModelAndView("redirect:/error");
		
		ModelAndView mav = new ModelAndView("applicationDetailed_user");
		mav.addObject("application", application);
		return mav;
	}
	

	/*
	 * @RequestMapping(value = "/update/{id}", method = RequestMethod.GET) public
	 * ModelAndView update(@PathVariable("id") int id) { ModelAndView mav = new
	 * ModelAndView("application_detailed"); Application application =
	 * applicationService.getById(id); mav.addObject("applicationForm",
	 * application);
	 * 
	 * return mav; }
	 */

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
			return new ModelAndView("error");
		}
		
		applicationService.saveOrUpdate(application);

		return new ModelAndView("apply_success");
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
		SimpleDateFormat fmt = new SimpleDateFormat("mm/dd/yyyy");
		try {
			application.setInterviewTime(fmt.parse(request.getParameter("interviewTime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationService.saveOrUpdate(application);

		ModelAndView mav = new ModelAndView("applicationDetailed_company");
		mav.addObject("application", application);
		return mav;
	}
	
	@RequestMapping(value = "/company/reject/{id}", method = RequestMethod.GET)
	public ModelAndView reject(@PathVariable("id") int id, HttpServletRequest request) {
		Application application = applicationService.getById(id);
		application.setStatus("Decided");
		application.setResult("Rejected");
		application.setComments(request.getParameter("comments"));
		applicationService.saveOrUpdate(application);
		ModelAndView mav = new ModelAndView("applicationDetailed_company");
		mav.addObject("application", application);
		return mav;
	}

}
