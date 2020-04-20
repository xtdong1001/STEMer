package com.xdong.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Company;
import com.xdong.model.Position;
import com.xdong.service.IGenericService;
import com.xdong.service.IPositionService;

@Controller
@RequestMapping(value = "/position")
public class PositionController {

	private static final Logger logger = Logger.getLogger(PositionController.class);
	
	@Autowired
	IPositionService<Position> positionService;
	private static final int MAXPOSITION_USER = 12;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("position/list");
		List list = positionService.getAll();
		model.addObject("list", list);

		return model;
	}
	
	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public ModelAndView listLimit(@PathVariable("page") int page) {
		List positions = positionService.getAllLimit((page-1)*MAXPOSITION_USER, MAXPOSITION_USER);
		int maxpages = (int)Math.ceil((double)positionService.getCount()/MAXPOSITION_USER);
		
		ModelAndView model = new ModelAndView("positions_user");
		model.addObject("positions", positions);
		model.addObject("pages", maxpages);
		model.addObject("currentPage", page);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("positionDetailed_user");
		Position position = positionService.getById(id);
		mav.addObject("position", position);

		return mav;
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public ModelAndView getCompanySide(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("positionDetailed_company");
		Position position = positionService.getById(id);
		mav.addObject("position", position);

		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("positionEdit");
		Position position = new Position();
		mav.addObject("position", position);

		return mav;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("positionEdit");
		Position position = positionService.getById(id);
		mav.addObject("position", position);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("position") Position position, BindingResult result, HttpServletRequest request) {
		positionService.validate(position, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("positionEdit");
			mav.addObject("position", position);
			return mav;
		}
			 
		position.setPublishTime(new Date());
		Company company = new Company();
		company.setCompanyId((Integer)request.getSession(false).getAttribute("companyId"));
		position.setCompany(company);
		positionService.saveOrUpdate(position);

		return new ModelAndView("redirect:/company/index");
	}

}
