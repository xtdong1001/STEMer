package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.Application;

@Repository
public class ApplicationDao implements IApplicationDao<Application>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(Application.class);
		return (List)criteria.list();
	}

	@Override
	public Application getById(int id) {
		Application Application = (Application)getSession().get(Application.class, id);
		return Application;
	}

	@Override
	public void saveOrUpdate(Application Application) {
		getSession().saveOrUpdate(Application);
	}

	@Override
	public void add(Application Application) {
		getSession().save(Application);
	}

	@Override
	public void deleteById(int id) {
		Application Application = (Application)getSession().get(Application.class, id);
		getSession().delete(Application);		
	}

	@Override
	public void delete(Application Application) {
		getSession().delete(Application);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(Application.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(Application.class)
				.setMaxResults(offset)
				.setFirstResult(start)
				.addOrder(Order.desc("publishTime"))
				.list();
	}


}
