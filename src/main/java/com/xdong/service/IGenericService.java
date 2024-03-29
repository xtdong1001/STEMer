package com.xdong.service;

import java.util.List;

import org.springframework.validation.Errors;

public interface IGenericService<T> {
	public abstract List getAll();
	public abstract List search(String key);
	public abstract T getById(int id);
	public abstract void add(T entity);
	public abstract void saveOrUpdate(T entity);
	public abstract void deleteById(int id);
	public abstract void delete(T entity);
	public abstract int getCount();
	public abstract List getAllLimit(int start, int offset);
	public void validate(Object target, Errors errors);
	
}
