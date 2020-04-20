package com.xdong.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Experience;

@Repository
public class ExperienceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Experience.class.isAssignableFrom(clazz);
		//is the experience could be assignable from the clazz
		//clazz is an experience or a subclass of experience
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "emptyTitle", "Please input the title.");
		ValidationUtils.rejectIfEmpty(errors, "company", "emptyCompany", "Please input the company.");
		ValidationUtils.rejectIfEmpty(errors, "location", "emptyLocation", "Please input the location.");
		ValidationUtils.rejectIfEmpty(errors, "fromDate", "emptyFromDate", "Please input the from date.");
		ValidationUtils.rejectIfEmpty(errors, "toDate", "emptyToDate", "Please input the to date.");
	}
}
