package com.xdong.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Application;
import com.xdong.service.IGenericService;
import com.xdong.service.IApplicationService;

@Controller
public class ApplicationController {

	@Autowired
	IApplicationService<Application> applicationService;
	private static final int MAXPOSITION_USER = 12;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("application/list");
		List list = applicationService.getAll();
		model.addObject("list", list);

		return model;
	}
	
	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public ModelAndView listLimit(@PathVariable("page") int page) {
		List applications = applicationService.getAllLimit((page-1)*MAXPOSITION_USER, MAXPOSITION_USER);
		int maxpages = (int)Math.ceil((double)applicationService.getCount()/MAXPOSITION_USER);
		
		ModelAndView model = new ModelAndView("applications_user");
		model.addObject("applications", applications);
		model.addObject("pages", maxpages);
		model.addObject("currentPage", page);
		return model;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("applicationDetailed_user");
		Application application = applicationService.getById(id);
		mav.addObject("application", application);

		return mav;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("application_detailed");
		Application application = applicationService.getById(id);
		mav.addObject("applicationForm", application);

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		applicationService.deleteById(id);

		return new ModelAndView("redirect:/application/list");
	}

	@RequestMapping(value = "/apply/{positionId}", method = RequestMethod.GET)
	public ModelAndView onGet(HttpServletRequest request, HttpServletResponse response, @PathVariable("positionId") int positionId) {
		if(request.getSession(false) == null || request.getSession(false).getAttribute("userId") == null) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("apply");
		Application application = new Application();
		mav.addObject("application", application);
		mav.addObject("positionId",positionId);
		return mav;
	}

	@RequestMapping(value = "/application/submit", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("application") Application application) {
		application.setApplyTime(new Date());
		application.setStatus("Pending");
		applicationService.saveOrUpdate(application);

		return new ModelAndView("welcome");
	}
}
