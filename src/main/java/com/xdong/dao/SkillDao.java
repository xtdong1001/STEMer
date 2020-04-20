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

import com.xdong.model.Skill;

@Repository
public class SkillDao implements IGenericDao<Skill>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(Skill.class);
		return (List)criteria.list();
	}

	@Override
	public Skill getById(int id) {
		Skill skill = (Skill)getSession().get(Skill.class, id);
		return skill;
	}

	@Override
	public void saveOrUpdate(Skill skill) {
		getSession().saveOrUpdate(skill);
	}

	@Override
	public void add(Skill skill) {
		getSession().save(skill);
	}

	@Override
	public void deleteById(int id) {
		Skill skill = (Skill)getSession().get(Skill.class, id);
		getSession().delete(skill);		
	}

	@Override
	public void delete(Skill skill) {
		getSession().delete(skill);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(Skill.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(Skill.class)
				.setMaxResults(offset)
				.setFirstResult(start)
				.list();
	}
}
