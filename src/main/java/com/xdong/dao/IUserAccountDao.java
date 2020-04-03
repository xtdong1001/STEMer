package com.xdong.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xdong.model.UserAccount;

public interface IUserAccountDao {
	public abstract List getAll();
	public abstract UserAccount getById(int id);
	public abstract void add(UserAccount userAccount);
	public abstract void saveOrUpdate(UserAccount userAccount);
	public abstract void deleteById(int id);
	public abstract void delete(UserAccount userAccount);
	public abstract int validate(UserAccount userAccount);
}
