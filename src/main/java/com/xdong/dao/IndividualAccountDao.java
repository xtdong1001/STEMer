package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.IndividualAccount;

@Repository
public class IndividualAccountDao implements IGenericDao<IndividualAccount>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(IndividualAccount.class);
		return (List)criteria.list();
	}

	@Override
	public IndividualAccount getById(int id) {
		IndividualAccount individualAccount = (IndividualAccount)getSession().get(IndividualAccount.class, id);
		individualAccount.getApplications().size();
		return individualAccount;
	}

	@Override
	public void saveOrUpdate(IndividualAccount individualAccount) {
		getSession().saveOrUpdate(individualAccount);
	}

	@Override
	public void add(IndividualAccount individualAccount) {
		getSession().save(individualAccount);
	}

	@Override
	public void deleteById(int id) {
		IndividualAccount individualAccount = (IndividualAccount)getSession().get(IndividualAccount.class, id);
		getSession().delete(individualAccount);		
	}

	@Override
	public void delete(IndividualAccount individualAccount) {
		getSession().delete(individualAccount);	
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
}
