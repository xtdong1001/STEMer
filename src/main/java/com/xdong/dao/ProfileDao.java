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

import com.xdong.model.Profile;

@Repository
public class ProfileDao implements IGenericDao<Profile>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(Profile.class);
		return (List)criteria.list();
	}

	@Override
	public Profile getById(int id) {
		Profile profile = (Profile)getSession().get(Profile.class, id);
		profile.getExperiences().size();
		profile.getEducations().size();
		profile.getSkills().size();
		return profile;
	}

	@Override
	public void saveOrUpdate(Profile profile) {
		getSession().saveOrUpdate(profile);
	}

	@Override
	public void add(Profile profile) {
		getSession().save(profile);
	}

	@Override
	public void deleteById(int id) {
		Profile profile = (Profile)getSession().get(Profile.class, id);
		getSession().delete(profile);		
	}

	@Override
	public void delete(Profile profile) {
		getSession().delete(profile);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(Profile.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(Profile.class)
				.setMaxResults(offset)
				.setFirstResult(start)
				.list();
	}
}
