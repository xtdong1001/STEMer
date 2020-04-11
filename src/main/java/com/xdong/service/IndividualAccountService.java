package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdong.dao.IndividualAccountDao;
import com.xdong.model.IndividualAccount;

@Service
@Transactional
public class IndividualAccountService implements IGenericService<IndividualAccount> {

	IndividualAccountDao individualAccountDao;

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
		individualAccountDao.saveOrUpdate(individualAccount);
	}

	@Override
	public void deleteById(int id) {
		individualAccountDao.deleteById(id);
	}

	@Override
	public void add(IndividualAccount individualAccount) {
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
}
