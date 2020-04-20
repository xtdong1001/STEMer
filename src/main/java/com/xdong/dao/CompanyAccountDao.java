package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.CompanyAccount;

@Repository
public class CompanyAccountDao implements IGenericDao<CompanyAccount>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(CompanyAccount.class);
		return (List)criteria.list();
	}

	@Override
	public CompanyAccount getById(int id) {
		CompanyAccount companyAccount = (CompanyAccount)getSession().get(CompanyAccount.class, id);
		return companyAccount;
	}

	@Override
	public void saveOrUpdate(CompanyAccount companyAccount) {
		getSession().saveOrUpdate(companyAccount);
	}

	@Override
	public void add(CompanyAccount companyAccount) {
		getSession().save(companyAccount);
	}

	@Override
	public void deleteById(int id) {
		CompanyAccount companyAccount = (CompanyAccount)getSession().get(CompanyAccount.class, id);
		getSession().delete(companyAccount);		
	}

	@Override
	public void delete(CompanyAccount companyAccount) {
		getSession().delete(companyAccount);	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getAllLimit(int start, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List search(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
