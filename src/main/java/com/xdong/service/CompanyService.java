package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.CompanyDao;
import com.xdong.model.Company;
import com.xdong.validator.CompanyValidator;
import com.xdong.validator.PositionValidator;

@Service
@Transactional
public class CompanyService implements IGenericService<Company> {

	CompanyDao companyDao;
	CompanyValidator companyValidator;

	@Autowired
	public void setCustomerDao(CompanyDao companyDao, CompanyValidator companyValidator) {
		this.companyDao = companyDao;
		this.companyValidator = companyValidator;
	}

	@Override
	public List<Company> getAll() {
		return companyDao.getAll();
	}

	@Override
	public Company getById(int id) {
		return companyDao.getById(id);
	}

	@Override
	public void saveOrUpdate(Company company) {
		companyDao.saveOrUpdate(company);
	}

	@Override
	public void deleteById(int id) {
		companyDao.deleteById(id);
	}

	@Override
	public void add(Company company) {
		companyDao.add(company);
	}

	@Override
	public void delete(Company company) {
		companyDao.delete(company);
	}

	@Override
	public int getCount() {
		return companyDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return companyDao.getAllLimit(start, offset);
	}

	@Override
	public void validate(Object target, Errors errors) {
		companyValidator.validate(target, errors);
	}

	@Override
	public List search(String key) {
		return companyDao.search(key);
	}

}
