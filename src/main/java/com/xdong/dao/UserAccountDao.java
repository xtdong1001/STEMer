package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.UserAccount;

@Repository
public class UserAccountDao implements IUserAccountDao<UserAccount>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(UserAccount.class);
		return (List)criteria.list();
	}

	@Override
	public UserAccount getById(int id) {
		UserAccount userAccount = (UserAccount)getSession().get(UserAccount.class, id);
		return userAccount;
	}

	@Override
	public void saveOrUpdate(UserAccount userAccount) {
		getSession().saveOrUpdate(userAccount);
	}

	@Override
	public void add(UserAccount userAccount) {
		getSession().save(userAccount);
	}

	@Override
	public void deleteById(int id) {
		UserAccount userAccount = (UserAccount)getSession().get(UserAccount.class, id);
		getSession().delete(userAccount);		
	}

	@Override
	public void delete(UserAccount userAccount) {
		getSession().delete(userAccount);	
	}

	@Override
	public UserAccount getByEmail(String email) {
		UserAccount result = (UserAccount) getSession()
				.createCriteria(UserAccount.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
		return result;
	}
}
