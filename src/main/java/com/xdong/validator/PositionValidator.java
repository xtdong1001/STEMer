package com.xdong.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Position;

@Repository
public class PositionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Position.class.isAssignableFrom(clazz);
		//is the position could be assignable from the clazz
		//clazz is an position or a subclass of position
	}

	@Override
	public void validate(Object target, Errors errors) {
		Position position = (Position) target;
		
		ValidationUtils.rejectIfEmpty(errors, "title", "emptyTitle", "Please input the position title.");
		ValidationUtils.rejectIfEmpty(errors, "jobDescription", "emptyJD", "Please input the job description.");
		ValidationUtils.rejectIfEmpty(errors, "employmentType", "emptyType", "Please input the employment type.");
		ValidationUtils.rejectIfEmpty(errors, "responsibility", "emptyResponsibility", "Please input the required skills.");
		
	}

}
