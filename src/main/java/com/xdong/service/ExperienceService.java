package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.ExperienceDao;
import com.xdong.model.Experience;
import com.xdong.validator.ExperienceValidator;

@Service
@Transactional
public class ExperienceService implements IGenericService<Experience> {

	ExperienceDao experienceDao;
	ExperienceValidator experienceValidator;

	@Autowired
	public void setCustomerDao(ExperienceDao experienceDao, ExperienceValidator experienceValidator) {
		this.experienceDao = experienceDao;
		this.experienceValidator = experienceValidator;
	}

	@Override
	public List<Experience> getAll() {
		return experienceDao.getAll();
	}

	@Override
	public Experience getById(int id) {
		return experienceDao.getById(id);
	}

	@Override
	public void saveOrUpdate(Experience experience) {
		experienceDao.saveOrUpdate(experience);
	}

	@Override
	public void deleteById(int id) {
		experienceDao.deleteById(id);
	}

	@Override
	public void add(Experience experience) {
		experienceDao.add(experience);
	}

	@Override
	public void delete(Experience experience) {
		experienceDao.delete(experience);
	}

	@Override
	public int getCount() {
		return experienceDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return experienceDao.getAllLimit(start, offset);
	}

	@Override
	public void validate(Object target, Errors errors) {
		experienceValidator.validate(target, errors);
	}

}
