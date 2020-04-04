package com.xdong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Position;
import com.xdong.service.IGenericService;
import com.xdong.service.IPositionService;

@Controller
@RequestMapping(value = "/position")
public class PositionController {

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
	
	@RequestMapping(value = "/list/company/{companyId}/{page}", method = RequestMethod.GET)
	public ModelAndView listByCompanyLimit(@PathVariable("companyId") int companyId, @PathVariable("page") int page) {
		List positions = positionService.getByCompanyId(companyId, (page-1)*MAXPOSITION_USER, MAXPOSITION_USER);
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

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("position_detailed");
		Position position = positionService.getById(id);
		mav.addObject("positionForm", position);

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		positionService.deleteById(id);

		return new ModelAndView("redirect:/position/list");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("position/form");
		Position position = new Position();
		mav.addObject("positionForm", position);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("positionForm") Position position) {
		positionService.saveOrUpdate(position);

		return new ModelAndView("redirect:/position/list");
	}
}
