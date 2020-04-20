package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.EduBackground;

@Repository
public class EduBackgroundDao implements IGenericDao<EduBackground>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(EduBackground.class);
		return (List)criteria.list();
	}

	@Override
	public EduBackground getById(int id) {
		EduBackground eduBackground = (EduBackground)getSession().get(EduBackground.class, id);
		return eduBackground;
	}

	@Override
	public void saveOrUpdate(EduBackground eduBackground) {
		getSession().saveOrUpdate(eduBackground);
	}

	@Override
	public void add(EduBackground eduBackground) {
		getSession().save(eduBackground);
	}

	@Override
	public void deleteById(int id) {
		EduBackground eduBackground = (EduBackground)getSession().get(EduBackground.class, id);
		getSession().delete(eduBackground);		
	}

	@Override
	public void delete(EduBackground eduBackground) {
		getSession().delete(eduBackground);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(EduBackground.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(EduBackground.class)
				.setMaxResults(offset)
				.setFirstResult(start)
				.list();
	}
}
