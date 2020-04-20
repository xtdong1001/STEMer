package com.xdong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Company;
import com.xdong.model.Experience;
import com.xdong.model.Profile;
import com.xdong.service.IGenericService;

@Controller
@RequestMapping(value = "/experience")
public class ExperienceController {

	@Autowired
	IGenericService<Experience> experienceService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("experienceDetailed_user");
		Experience experience = experienceService.getById(id);
		mav.addObject("experience", experience);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("experienceEdit");
		Experience experience = new Experience();
		mav.addObject("experience", experience);
		return mav;
	}
	
	@RequestMapping(value = "/update/{experId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("experId") int experId) {
		ModelAndView mav = new ModelAndView("experienceEdit");
		Experience experience = experienceService.getById(experId);
		mav.addObject("experience", experience);
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("experience") Experience experience, BindingResult result, HttpServletRequest request) {
		experienceService.validate(experience, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("experienceEdit");
			mav.addObject("experience", experience);
			return mav;
		}
		Profile profile = new Profile();
		profile.setProfileId((Integer)request.getSession(false).getAttribute("profileId"));
		experience.setProfile(profile);
		experienceService.saveOrUpdate(experience);
		return new ModelAndView("redirect:/profile/" + experience.getProfile().getProfileId());
	}

	

}
