package com.xdong.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.RegisterAccount;
import com.xdong.model.UserAccount;
import com.xdong.model.UserAccount;

@Repository
public class RegisterAccountValidator implements Validator {

	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	private static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterAccount.class.isAssignableFrom(clazz);
		//is the userAccount could be assignable from the clazz
		//clazz is an userAccount or a subclass of userAccount
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterAccount registerAccount = (RegisterAccount) target;
		System.out.println(registerAccount.getPassword());
		System.out.println(registerAccount.getPassword2());
		
		ValidationUtils.rejectIfEmpty(errors, "email", "emptyEmail", "Please input the email.");
		ValidationUtils.rejectIfEmpty(errors, "password", "emptyPassword", "Please input the password.");
		ValidationUtils.rejectIfEmpty(errors, "password2", "emptyPassword2", "Please input the password.");
		
		if(!registerAccount.getEmail().equals("") && !registerAccount.getEmail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("email", "errorEmail", "Please input a valid email");
		}
		if(!registerAccount.getEmail().equals("") && !registerAccount.getPassword().equals(registerAccount.getPassword2())) {
			errors.rejectValue("password2", "errorPwd2", "Please input the same password");
		}
		
		if(!registerAccount.getEmail().equals("") && !registerAccount.getPassword().matches(PASSWORD_PATTERN)) {
			errors.rejectValue("password2", "errorPwd2", "Be between 8 and 40 characters long\r\n" + 
					"Contain at least one digit.\r\n" + 
					"Contain at least one lower case character.\r\n" + 
					"Contain at least one upper case character.\r\n" + 
					"Contain at least on special character from [ @ # $ % ! . ]");
		}
	}

}
