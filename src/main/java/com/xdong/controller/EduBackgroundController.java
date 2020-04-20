package com.xdong.controller;

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

import com.xdong.model.EduBackground;
import com.xdong.model.EduBackground;
import com.xdong.model.Profile;
import com.xdong.service.IGenericService;

@Controller
@RequestMapping(value = "/eduBackground")
public class EduBackgroundController {
	
	private static final Logger logger = Logger.getLogger(EduBackgroundController.class);

	@Autowired
	IGenericService<EduBackground> eduBackgroundService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("eduBackgroundDetailed_user");
		EduBackground eduBackground = eduBackgroundService.getById(id);
		mav.addObject("eduBackground", eduBackground);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("eduBackgroundEdit");
		EduBackground eduBackground = new EduBackground();
		mav.addObject("eduBackground", eduBackground);
		return mav;
	}
	
	
	@RequestMapping(value = "/update/{experId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("experId") int experId) {
		ModelAndView mav = new ModelAndView("eduBackgroundEdit");
		EduBackground eduBackground = eduBackgroundService.getById(experId);
		mav.addObject("eduBackground", eduBackground);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("eduBackground") EduBackground eduBackground, BindingResult result, HttpServletRequest request) {
		eduBackgroundService.validate(eduBackground, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("eduBackgroundEdit");
			mav.addObject("eduBackground", eduBackground);
			return mav;
		}
		Profile profile = new Profile();
		profile.setProfileId((Integer)request.getSession(false).getAttribute("profileId"));
		eduBackground.setProfile(profile);
		eduBackgroundService.saveOrUpdate(eduBackground);
		return new ModelAndView("redirect:/profile/" + eduBackground.getProfile().getProfileId());
	}
}
