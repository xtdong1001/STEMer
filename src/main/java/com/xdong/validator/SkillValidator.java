package com.xdong.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xdong.model.Skill;

@Repository
public class SkillValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Skill.class.isAssignableFrom(clazz);
		//is the eduBackground could be assignable from the clazz
		//clazz is an eduBackground or a subclass of eduBackground
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "emptyName", "Please input the name.");
	}
}
