package com.xdong.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xdong.model.IndividualAccount;

public interface IUserAccountDao<T extends Serializable>  {
	public abstract List getAll();
	public abstract T getById(int id);
	public abstract void add(T entity);
	public abstract void saveOrUpdate(T entity);
	public abstract void deleteById(int id);
	public abstract void delete(T entity);
	public T getByEmail(String email);
}
