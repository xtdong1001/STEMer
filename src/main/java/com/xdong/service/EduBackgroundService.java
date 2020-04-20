package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.EduBackgroundDao;
import com.xdong.model.EduBackground;
import com.xdong.validator.EduBackgroundValidator;

@Service
@Transactional
public class EduBackgroundService implements IGenericService<EduBackground> {

	EduBackgroundDao eduBackgroundDao;
	EduBackgroundValidator eduBackgroundValidator;

	@Autowired
	public void setCustomerDao(EduBackgroundDao eduBackgroundDao, EduBackgroundValidator eduBackgroundValidator) {
		this.eduBackgroundDao = eduBackgroundDao;
		this.eduBackgroundValidator = eduBackgroundValidator;
	}

	@Override
	public List<EduBackground> getAll() {
		return eduBackgroundDao.getAll();
	}

	@Override
	public EduBackground getById(int id) {
		return eduBackgroundDao.getById(id);
	}

	@Override
	public void saveOrUpdate(EduBackground eduBackground) {
		eduBackgroundDao.saveOrUpdate(eduBackground);
	}

	@Override
	public void deleteById(int id) {
		eduBackgroundDao.deleteById(id);
	}

	@Override
	public void add(EduBackground eduBackground) {
		eduBackgroundDao.add(eduBackground);
	}

	@Override
	public void delete(EduBackground eduBackground) {
		eduBackgroundDao.delete(eduBackground);
	}

	@Override
	public int getCount() {
		return eduBackgroundDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return eduBackgroundDao.getAllLimit(start, offset);
	}

	@Override
	public void validate(Object target, Errors errors) {
		eduBackgroundValidator.validate(target, errors);
	}

}
