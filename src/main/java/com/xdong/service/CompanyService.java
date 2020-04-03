package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdong.dao.CompanyDao;
import com.xdong.model.Company;

@Service
@Transactional
public class CompanyService implements IGenericService<Company> {

	CompanyDao companyDao;

	@Autowired
	public void setCustomerDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
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

}
