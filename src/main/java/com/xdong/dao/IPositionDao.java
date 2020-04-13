package com.xdong.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface IPositionDao<T extends Serializable> {
	public abstract List getAll();
	public abstract T getById(int id);
	public abstract void add(T entity);
	public abstract void saveOrUpdate(T entity);
	public abstract void deleteById(int id);
	public abstract void delete(T entity);
	public abstract int getCount();
	public abstract List getAllLimit(int start, int offset);
	public abstract List getByCompanyId(int companyId);
}
