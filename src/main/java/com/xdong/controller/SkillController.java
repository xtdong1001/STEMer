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

import com.xdong.model.Skill;
import com.xdong.model.Skill;
import com.xdong.model.Profile;
import com.xdong.service.IGenericService;

@Controller
@RequestMapping(value = "/skill")
public class SkillController {

	@Autowired
	IGenericService<Skill> skillService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("skillDetailed_user");
		Skill skill = skillService.getById(id);
		mav.addObject("skill", skill);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("skillEdit");
		Skill skill = new Skill();
		mav.addObject("skill", skill);
		return mav;
	}
	
	
	@RequestMapping(value = "/update/{experId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("experId") int experId) {
		ModelAndView mav = new ModelAndView("skillEdit");
		Skill skill = skillService.getById(experId);
		mav.addObject("skill", skill);

		return mav;
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("skill") Skill skill, BindingResult result, HttpServletRequest request) {
		skillService.validate(skill, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("skillEdit");
			mav.addObject("skill", skill);
			return mav;
		}
		Profile profile = new Profile();
		profile.setProfileId((Integer)request.getSession(false).getAttribute("profileId"));
		skill.setProfile(profile);
		skillService.saveOrUpdate(skill);
		return new ModelAndView("redirect:/profile/" + skill.getProfile().getProfileId());
	}
	

}
