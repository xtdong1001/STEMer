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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xdong.model.Company;
import com.xdong.model.Profile;
import com.xdong.service.IGenericService;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

	@Autowired
	IGenericService<Profile> profileService;
	
	public static final String archivePath = "D:/xtdong/grad/6250 Web dev tools/Archive";

		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("profileDetailed_user");
		Profile profile = profileService.getById(id);
		mav.addObject("profile", profile);
		return mav;
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public ModelAndView getCompanySide(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("profileDetailed_company");
		Profile profile = profileService.getById(id);
		mav.addObject("profile", profile);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request) {
		Integer id = (Integer)request.getSession(false).getAttribute("profileId");
		ModelAndView mav = new ModelAndView("profileEdit");
		Profile profile = profileService.getById(id);
		mav.addObject("profile", profile);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("profile") Profile profile, BindingResult result, HttpServletRequest request) {
		profileService.validate(profile, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("profileEdit");
			mav.addObject("profile", profile);
			return mav;
		}
		
		CommonsMultipartFile logo = profile.getPortrait();
		if(logo.getSize() != 0) {
			String filename = logo.getOriginalFilename();
			filename = FilenameUtils.removeExtension(filename) 
					+ "_" + profile.getProfileId()
					+ "_" + Calendar.getInstance().getTimeInMillis() 
					+ "." + FilenameUtils.getExtension(filename);
			profile.setPortraitPath(filename);
			File file = new File(archivePath, filename);
			try {
				logo.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				return new ModelAndView("error");
			}
		}
		
		profileService.saveOrUpdate(profile);
		return new ModelAndView("redirect:/profile/"+profile.getProfileId());
	}
	
	@ResponseBody
	@RequestMapping(value = "/portrait", method = RequestMethod.GET)
	public String getLogo(HttpServletRequest request) {
		int profileId = (int) request.getSession(false).getAttribute("profileId");
		Profile profile =  profileService.getById(profileId);
		return profile.getPortraitPath();
	}
}
