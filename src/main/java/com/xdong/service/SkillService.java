package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.SkillDao;
import com.xdong.model.Skill;
import com.xdong.validator.SkillValidator;

@Service
@Transactional
public class SkillService implements IGenericService<Skill> {

	SkillDao skillDao;
	SkillValidator skillValidator;

	@Autowired
	public void setCustomerDao(SkillDao skillDao, SkillValidator skillValidator) {
		this.skillDao = skillDao;
		this.skillValidator = skillValidator;
	}

	@Override
	public List<Skill> getAll() {
		return skillDao.getAll();
	}

	@Override
	public Skill getById(int id) {
		return skillDao.getById(id);
	}

	@Override
	public void saveOrUpdate(Skill skill) {
		skillDao.saveOrUpdate(skill);
	}

	@Override
	public void deleteById(int id) {
		skillDao.deleteById(id);
	}

	@Override
	public void add(Skill skill) {
		skillDao.add(skill);
	}

	@Override
	public void delete(Skill skill) {
		skillDao.delete(skill);
	}

	@Override
	public int getCount() {
		return skillDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return skillDao.getAllLimit(start, offset);
	}

	@Override
	public void validate(Object target, Errors errors) {
		skillValidator.validate(target, errors);
	}

}
