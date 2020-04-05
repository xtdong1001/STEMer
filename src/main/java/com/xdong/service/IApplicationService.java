package com.xdong.service;

import java.util.List;

public interface IApplicationService<T> {
	public abstract List getAll();
	public abstract T getById(int id);
	public abstract void add(T entity);
	public abstract void saveOrUpdate(T entity);
	public abstract void deleteById(int id);
	public abstract void delete(T entity);
	public abstract int getCount();
	public abstract List getAllLimit(int start, int offset);
}
