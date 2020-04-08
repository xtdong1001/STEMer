package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.ApplicationDao;
import com.xdong.model.Application;
import com.xdong.validator.ApplicationValidator;

@Service
@Transactional
public class ApplicationService implements IApplicationService<Application> {

	ApplicationDao ApplicationDao;
	ApplicationValidator applicationValidator;

	@Autowired
	public void setCustomerDao(ApplicationDao ApplicationDao, ApplicationValidator validator) {
		this.ApplicationDao = ApplicationDao;
		applicationValidator = validator;
	}

	@Override
	public List<Application> getAll() {
		return ApplicationDao.getAll();
	}

	@Override
	public Application getById(int id) {
		return ApplicationDao.getById(id);
	}

	@Override
	public void saveOrUpdate(Application Application) {
		ApplicationDao.saveOrUpdate(Application);
	}

	@Override
	public void deleteById(int id) {
		ApplicationDao.deleteById(id);
	}

	@Override
	public void add(Application Application) {
  	}

	@Override
	public void delete(Application Application) {
		ApplicationDao.delete(Application);
	}

	@Override
	public int getCount() {
		return ApplicationDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return ApplicationDao.getAllLimit(start, offset);
	}

	@Override
	public void validate(Object target, Errors errors) {
		applicationValidator.validate(target, errors);
	}
}
