package com.xdong.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Profile;

@Repository
public class ProfileValidator implements Validator {

	private static final String ZIP_PATTERN = "^[0-9]{5}(?:-[0-9]{4})?$";
	private static final String IMAGE_PATTERN = "^(jpg|png|gif|bmp)$";
	private static final String YEAR_PATTERN = "^[0-9]{4}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Profile.class.isAssignableFrom(clazz);
		//is the profile could be assignable from the clazz
		//clazz is an profile or a subclass of profile
	}

	@Override
	public void validate(Object target, Errors errors) {
		Profile profile = (Profile) target;
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "emptyFN", "Please input the first name.");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "emptyLN", "Please input the last name.");
		ValidationUtils.rejectIfEmpty(errors, "phone", "emptyPhone", "Please input the phone number.");
		
		String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String phoneRegex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		String zipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
		
		if(profile.getEmail() != null && !profile.getEmail().matches(emailRegex)) {
			errors.rejectValue("email", "errorEmail", "Please input a valid email");
		}
		if(profile.getZipcode() != null && !profile.getZipcode().equals("") && !profile.getZipcode().matches(zipRegex)) {
			errors.rejectValue("zipcode", "errorZip", "Please input a valid zip code");
		}
		if(profile.getPhone() != null && !profile.getPhone().equals("") && !profile.getPhone().matches(phoneRegex)) {
			errors.rejectValue("phone", "errorPhone", "Please input a valid phone number");
		}
		
		if(profile.getPortrait().getSize() != 0) {
			String extension = FilenameUtils.getExtension(profile.getPortrait().getOriginalFilename());
			if(!extension.matches(IMAGE_PATTERN))
				errors.rejectValue("portrait", "errorPortrait", "Please upload a valid image.");
		}
	}

}
