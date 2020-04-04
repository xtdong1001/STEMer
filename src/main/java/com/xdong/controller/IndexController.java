package com.xdong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Company;
import com.xdong.model.Position;
import com.xdong.service.IGenericService;
import com.xdong.service.IPositionService;

@Controller
public class IndexController {
	
	@Autowired
	IPositionService<Position> positionService;
	@Autowired
	IGenericService<Company> companyService;
	
	private static final int POSITION_LIMIT = 8;
	private static final int COMPANY_LIMIT = 6;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		List positions = positionService.getAllLimit(0, POSITION_LIMIT);
		List companies = companyService.getAllLimit(0, COMPANY_LIMIT);
		ModelAndView model = new ModelAndView("index");
		model.addObject("positions", positions);
		model.addObject("companies", companies);
		return model;
	}
}
