package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;

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
		userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
		userAccountDao.saveOrUpdate(userAccount);
	}

	@Override
	public void deleteById(int id) {
		userAccountDao.deleteById(id);
	}

	@Override
	public void add(UserAccount userAccount) {
		userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
		userAccountDao.add(userAccount);
	}

	@Override
	public void delete(UserAccount userAccount) {
		userAccountDao.delete(userAccount);
	}

	@Override
	public boolean check(UserAccount userAccount) {
		UserAccount savedAccount = userAccountDao.getByEmail(userAccount.getEmail());
		return passwordEncoder.matches(userAccount.getPassword(), savedAccount.getPassword());
	}

	@Override
	public void validate(Object target, Errors errors) {
		userAccountValidator.validate(target, errors);
	}

	@Override
	public UserAccount getByEmail(String email) {
		return userAccountDao.getByEmail(email);
	}

}
