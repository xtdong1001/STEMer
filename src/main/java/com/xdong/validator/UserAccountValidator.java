package com.xdong.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.UserAccount;
import com.xdong.model.UserAccount;

@Repository
public class UserAccountValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserAccount.class.isAssignableFrom(clazz);
		//is the userAccount could be assignable from the clazz
		//clazz is an userAccount or a subclass of userAccount
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserAccount userAccount = (UserAccount) target;
		
		ValidationUtils.rejectIfEmpty(errors, "email", "emptyEmail", "Please input the email.");
		ValidationUtils.rejectIfEmpty(errors, "password", "emptyPassword", "Please input the password.");
		
		if(userAccount.getEmail() != null && !userAccount.getEmail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("email", "errorEmail", "Please input a valid email");
		}
	}

}
