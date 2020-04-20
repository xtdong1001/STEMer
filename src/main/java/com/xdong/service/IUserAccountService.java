package com.xdong.service;

import java.util.List;

import org.springframework.validation.Errors;

import com.xdong.model.UserAccount;

public interface IUserAccountService<T> {
	public abstract List getAll();
	public abstract T getById(int id);
	public abstract void add(T entity);
	public abstract void saveOrUpdate(T entity);
	public abstract void deleteById(int id);
	public abstract void delete(T entity);
	public abstract boolean check(T entity);
	public abstract T getByEmail(String email);
	public void validate(Object target, Errors errors);
}
