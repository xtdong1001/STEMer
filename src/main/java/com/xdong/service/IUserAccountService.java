package com.xdong.service;

import java.util.List;

import com.xdong.model.UserAccount;

public interface IUserAccountService {
	public abstract List getAll();
	public abstract UserAccount getById(int id);
	public abstract void add(UserAccount userAccount);
	public abstract void saveOrUpdate(UserAccount userAccount);
	public abstract void deleteById(int id);
	public abstract void delete(UserAccount userAccount);
	public abstract int validate(UserAccount userAccount);
}
