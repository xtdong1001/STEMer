package com.xdong.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Application;

@Repository
public class ApplicationValidator implements Validator {

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
		
		String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String phoneRegex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		String zipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
		
		if(application.getEmail() != null && !application.getEmail().matches(emailRegex)) {
			errors.rejectValue("email", "errorEmail", "Please input a valid email");
		}
		if(application.getZipcode() != null && !application.getZipcode().equals("") && !application.getZipcode().matches(zipRegex)) {
			errors.rejectValue("zipcode", "errorZip", "Please input a valid zip code");
		}
		if(application.getPhone() != null && !application.getPhone().equals("") && !application.getPhone().matches(phoneRegex)) {
			errors.rejectValue("phone", "errorPhone", "Please input a valid phone number");
		}
		
		if(application.getResume().getSize() == 0) {
			errors.rejectValue("resume", "errorResume", "Please upload a resume.");
		}
	}

}
