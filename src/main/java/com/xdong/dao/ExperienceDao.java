package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.Experience;

@Repository
public class ExperienceDao implements IGenericDao<Experience>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(Experience.class);
		return (List)criteria.list();
	}

	@Override
	public Experience getById(int id) {
		Experience experience = (Experience)getSession().get(Experience.class, id);
		return experience;
	}

	@Override
	public void saveOrUpdate(Experience experience) {
		getSession().saveOrUpdate(experience);
	}

	@Override
	public void add(Experience experience) {
		getSession().save(experience);
	}

	@Override
	public void deleteById(int id) {
		Experience experience = (Experience)getSession().get(Experience.class, id);
		getSession().delete(experience);		
	}

	@Override
	public void delete(Experience experience) {
		getSession().delete(experience);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(Experience.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(Experience.class)
				.setMaxResults(offset)
				.setFirstResult(start)
				.list();
	}

	@Override
	public List search(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
