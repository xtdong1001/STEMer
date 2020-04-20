package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.ProfileDao;
import com.xdong.model.Profile;
import com.xdong.validator.ProfileValidator;

@Service
@Transactional
public class ProfileService implements IGenericService<Profile> {

	ProfileDao profileDao;
	ProfileValidator profileValidator;

	@Autowired
	public void setCustomerDao(ProfileDao profileDao, ProfileValidator profileValidator) {
		this.profileDao = profileDao;
		this.profileValidator = profileValidator;
	}

	@Override
	public List<Profile> getAll() {
		return profileDao.getAll();
	}

	@Override
	public Profile getById(int id) {
		return profileDao.getById(id);
	}

	@Override
	public void saveOrUpdate(Profile profile) {
		profileDao.saveOrUpdate(profile);
	}

	@Override
	public void deleteById(int id) {
		profileDao.deleteById(id);
	}

	@Override
	public void add(Profile profile) {
		profileDao.add(profile);
	}

	@Override
	public void delete(Profile profile) {
		profileDao.delete(profile);
	}

	@Override
	public int getCount() {
		return profileDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return profileDao.getAllLimit(start, offset);
	}

	@Override
	public void validate(Object target, Errors errors) {
		profileValidator.validate(target, errors);
	}

	@Override
	public List search(String key) {
		return profileDao.search(key);
	}

}
