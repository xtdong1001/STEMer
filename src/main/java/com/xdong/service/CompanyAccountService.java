package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.CompanyAccountDao;
import com.xdong.model.CompanyAccount;

@Service
@Transactional
public class CompanyAccountService implements IGenericService<CompanyAccount> {

	CompanyAccountDao companyAccountDao;

	@Autowired
	public void setCompanyAccountDao(CompanyAccountDao companyAccountDao) {
		this.companyAccountDao = companyAccountDao;
	}

	@Override
	public List<CompanyAccount> getAll() {
		return companyAccountDao.getAll();
	}

	@Override
	public CompanyAccount getById(int id) {
		return companyAccountDao.getById(id);
	}

	@Override
	public void saveOrUpdate(CompanyAccount companyAccount) {
		companyAccountDao.saveOrUpdate(companyAccount);
	}

	@Override
	public void deleteById(int id) {
		companyAccountDao.deleteById(id);
	}

	@Override
	public void add(CompanyAccount companyAccount) {
		companyAccountDao.add(companyAccount);
	}

	@Override
	public void delete(CompanyAccount companyAccount) {
		companyAccountDao.delete(companyAccount);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getAllLimit(int start, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
