package com.xdong.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Company;
import com.xdong.model.EduBackground;

@Repository
public class EduBackgroundValidator implements Validator {

	private static final String YEAR_PATTERN = "^[0-9]{4}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return EduBackground.class.isAssignableFrom(clazz);
		//is the eduBackground could be assignable from the clazz
		//clazz is an eduBackground or a subclass of eduBackground
	}

	@Override
	public void validate(Object target, Errors errors) {
		EduBackground eduBackground = (EduBackground) target;
		
		ValidationUtils.rejectIfEmpty(errors, "university", "emptyUniversity", "Please input the university.");
		ValidationUtils.rejectIfEmpty(errors, "degree", "emptyDegree", "Please input the degree.");
		ValidationUtils.rejectIfEmpty(errors, "major", "emptyMajor", "Please input the major.");
		ValidationUtils.rejectIfEmpty(errors, "fromYear", "emptyFromYear", "Please input the from date.");
		ValidationUtils.rejectIfEmpty(errors, "toYear", "emptyToYear", "Please input the to date.");
		if(eduBackground.getFromYear() != null && !eduBackground.getFromYear().equals("") && !eduBackground.getFromYear().matches(YEAR_PATTERN)) {
			errors.rejectValue("fromYear", "errorFromYear", "Please input a valid year");
		}
		
		if(eduBackground.getToYear() != null && !eduBackground.getToYear().equals("") && !eduBackground.getToYear().matches(YEAR_PATTERN)) {
			errors.rejectValue("toYear", "errorToYear", "Please input a valid year");
		}
		
	}
}
