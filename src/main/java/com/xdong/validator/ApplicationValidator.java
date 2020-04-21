package com.xdong.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Application;

@Repository
public class ApplicationValidator implements Validator {

	private static final String RESUME_PATTERN = "^(pdf|PDF)$";
	private static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String PHONE_PATTERN = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
	private static final String ZIP_PATTERN = "^[0-9]{5}(?:-[0-9]{4})?$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Application.class.isAssignableFrom(clazz);
		//is the application could be assignable from the clazz
		//clazz is an application or a subclass of application
	}

	@Override
	public void validate(Object target, Errors errors) {
		Application application = (Application) target;
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "emptyFN", "Please input the first name.");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "emptyLN", "Please input the last name.");
		ValidationUtils.rejectIfEmpty(errors, "phone", "emptyPhone", "Please input the phone number.");
		ValidationUtils.rejectIfEmpty(errors, "email", "emptyEmail", "Please input the email.");		
		
		
		if(application.getEmail() != null && !application.getEmail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("email", "errorEmail", "Please input a valid email");
		}
		if(application.getZipcode() != null && !application.getZipcode().equals("") && !application.getZipcode().matches(ZIP_PATTERN)) {
			errors.rejectValue("zipcode", "errorZip", "Please input a valid zip code");
		}
		if(application.getPhone() != null && !application.getPhone().equals("") && !application.getPhone().matches(PHONE_PATTERN)) {
			errors.rejectValue("phone", "errorPhone", "Please input a valid phone number");
		}
		
		if(application.getResume().getSize() == 0) {
			errors.rejectValue("resume", "errorResume", "Please upload a resume.");
		}
		
		if(application.getResume().getSize() != 0) {
			String extension = FilenameUtils.getExtension(application.getResume().getOriginalFilename());
			if(!extension.matches(RESUME_PATTERN))
				errors.rejectValue("resume", "errorResume", "Please upload a valid resume(pdf).");
		}
	}

}
