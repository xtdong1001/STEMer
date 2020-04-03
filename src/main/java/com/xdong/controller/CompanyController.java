package com.xdong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Company;
import com.xdong.service.IGenericService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	IGenericService<Company> companyService;
	
	private static final int MAXCOMPANY_USER = 12;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("company/list");
		List list = companyService.getAll();
		model.addObject("list", list);

		return model;
	}
	
	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public ModelAndView listLimit(@PathVariable("page") int page) {
		List companies = companyService.getAllLimit((page-1)*MAXCOMPANY_USER, MAXCOMPANY_USER);
		int maxpages = (int)Math.ceil((double)companyService.getCount()/MAXCOMPANY_USER);
		
		ModelAndView model = new ModelAndView("companies_user");
		model.addObject("companies", companies);
		model.addObject("pages", maxpages);
		model.addObject("currentPage", page);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("companyDetailed_user");
		Company company = companyService.getById(id);
		mav.addObject("company", company);

		return mav;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("company_detailed");
		Company company = companyService.getById(id);
		mav.addObject("companyForm", company);

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		companyService.deleteById(id);

		return new ModelAndView("redirect:/company/list");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("company/form");
		Company company = new Company();
		mav.addObject("companyForm", company);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("companyForm") Company company) {
		companyService.saveOrUpdate(company);

		return new ModelAndView("redirect:/company/list");
	}
}
