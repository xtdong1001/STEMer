package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.UserAccountDao;
import com.xdong.model.UserAccount;
import com.xdong.validator.UserAccountValidator;

@Service
@Transactional
public class UserAccountService implements IUserAccountService<UserAccount> {

	UserAccountDao userAccountDao;
	UserAccountValidator userAccountValidator;

	@Autowired
	public void setCustomerDao(UserAccountDao userAccountDao, UserAccountValidator userAccountValidator) {
		this.userAccountDao = userAccountDao;
		this.userAccountValidator = userAccountValidator;
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
	public int check(UserAccount userAccount) {
		return userAccountDao.check(userAccount);
	}

	@Override
	public void validate(Object target, Errors errors) {
		userAccountValidator.validate(target, errors);
	}

	@Override
	public int checkEmailExist(String email) {
		return userAccountDao.checkEmailExist(email);
	}

}
