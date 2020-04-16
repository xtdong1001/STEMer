package com.xdong.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.xdong.model.Company;
import com.xdong.service.IGenericService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	IGenericService<Company> companyService;
	
	private static final int MAXCOMPANY_USER = 12;
	public static final String archivePath = "D:/xtdong/grad/6250 Web dev tools/Archive";

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
		mav.addObject("positions", company.getPositions());
		return mav;
	}
	
	@RequestMapping(value = "/mine", method = RequestMethod.GET)
	public ModelAndView getMineCompany(HttpServletRequest request) {
		Integer id = (Integer)request.getSession(false).getAttribute("companyId");
		ModelAndView mav = new ModelAndView("companyDetailed_company");
		Company company = companyService.getById(id);
		mav.addObject("company", company);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request) {
		Integer id = (Integer)request.getSession(false).getAttribute("companyId");
		ModelAndView mav = new ModelAndView("companyEdit");
		Company company = companyService.getById(id);
		mav.addObject("company", company);

		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("company/form");
		Company company = new Company();
		mav.addObject("companyForm", company);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("company") Company company, BindingResult result, HttpServletRequest request) {
		companyService.validate(company, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("companyEdit");
			mav.addObject("company", company);
			return mav;
		}
		
		CommonsMultipartFile logo = company.getLogo();
		if(logo.getSize() != 0) {
			String filename = logo.getOriginalFilename();
			filename = FilenameUtils.removeExtension(filename) 
					+ "_" + company.getCompanyId()
					+ "_" + Calendar.getInstance().getTimeInMillis() 
					+ "." + FilenameUtils.getExtension(filename);
			company.setLogoPath(filename);
			File file = new File(archivePath, filename);
			try {
				logo.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				return new ModelAndView("error");
			}
		}
		
		companyService.saveOrUpdate(company);
		return new ModelAndView("redirect:/company/mine");
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getPositions(HttpServletRequest request) {
		int companyId = (int) request.getSession(false).getAttribute("companyId");
		Company company =  companyService.getById(companyId);
		List positions = company.getPositions();
		ModelAndView model = new ModelAndView("positions_company");
		model.addObject("positions", positions);
		return model;
	}
}
