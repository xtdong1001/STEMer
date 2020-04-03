package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdong.dao.UserAccountDao;
import com.xdong.model.UserAccount;

@Service
@Transactional
public class UserAccountService implements IUserAccountService {

	UserAccountDao userAccountDao;

	@Autowired
	public void setCustomerDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	@Override
	public List<UserAccount> getAll() {
		return userAccountDao.getAll();
	}

	@Override
	public UserAccount getById(int id) {
		return userAccountDao.getById(id);
	}

	@Override
	public void saveOrUpdate(UserAccount userAccount) {
		userAccountDao.saveOrUpdate(userAccount);
	}

	@Override
	public void deleteById(int id) {
		userAccountDao.deleteById(id);
	}

	@Override
	public void add(UserAccount userAccount) {
		userAccountDao.add(userAccount);
	}

	@Override
	public void delete(UserAccount userAccount) {
		userAccountDao.delete(userAccount);
	}

	@Override
	public int validate(UserAccount userAccount) {
		return userAccountDao.validate(userAccount);
	}

}
