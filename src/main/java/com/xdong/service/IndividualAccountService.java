package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.IndividualAccountDao;
import com.xdong.model.IndividualAccount;

@Service
@Transactional
public class IndividualAccountService implements IGenericService<IndividualAccount> {

	IndividualAccountDao individualAccountDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setIndividualAccountDao(IndividualAccountDao individualAccountDao) {
		this.individualAccountDao = individualAccountDao;
	}

	@Override
	public List<IndividualAccount> getAll() {
		return individualAccountDao.getAll();
	}

	@Override
	public IndividualAccount getById(int id) {
		return individualAccountDao.getById(id);
	}

	@Override
	public void saveOrUpdate(IndividualAccount individualAccount) {
		individualAccount.setPassword(passwordEncoder.encode(individualAccount.getPassword()));
		individualAccountDao.saveOrUpdate(individualAccount);
	}

	@Override
	public void deleteById(int id) {
		individualAccountDao.deleteById(id);
	}

	@Override
	public void add(IndividualAccount individualAccount) {
		individualAccount.setPassword(passwordEncoder.encode(individualAccount.getPassword()));
		individualAccountDao.add(individualAccount);
	}

	@Override
	public void delete(IndividualAccount entity) {
		// TODO Auto-generated method stub
		
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

	@Override
	public List search(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
