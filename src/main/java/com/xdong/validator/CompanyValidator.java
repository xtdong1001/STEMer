package com.xdong.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Company;

@Repository
public class CompanyValidator implements Validator {

	private static final String ZIP_PATTERN = "^[0-9]{5}(?:-[0-9]{4})?$";
	private static final String IMAGE_PATTERN = "^(jpg|png|gif|bmp)$";
	private static final String YEAR_PATTERN = "^[0-9]{4}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Company.class.isAssignableFrom(clazz);
		//is the company could be assignable from the clazz
		//clazz is an company or a subclass of company
	}

	@Override
	public void validate(Object target, Errors errors) {
		Company company = (Company) target;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "emptyName", "Please input the company name.");
		
		if(company.getZipcode() != null && !company.getZipcode().equals("") && !company.getZipcode().matches(ZIP_PATTERN)) {
			errors.rejectValue("zipcode", "errorZip", "Please input a valid zip code");
		}
		if(company.getFoundYear() != null && !company.getFoundYear().equals("") && !company.getFoundYear().matches(YEAR_PATTERN)) {
			errors.rejectValue("foundYear", "errorFoundYear", "Please input a valid year");
		}
		
		if(company.getLogo().getSize() != 0) {
			String extension = FilenameUtils.getExtension(company.getLogo().getOriginalFilename());
			if(!extension.matches(IMAGE_PATTERN))
				errors.rejectValue("logo", "errorLogo", "Please upload a valid image.");
		}
	}
}
