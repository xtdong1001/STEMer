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

import com.xdong.model.Position;

@Repository
public class PositionDao implements IPositionDao<Position>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(Position.class);
		return (List)criteria.add(Restrictions.eq("isAvailable", true)).list();
	}

	@Override
	public Position getById(int id) {
		Position position = (Position)getSession().get(Position.class, id);
		position.getApplications().size();
		return position;
	}

	@Override
	public void saveOrUpdate(Position position) {
		getSession().saveOrUpdate(position);
	}

	@Override
	public void add(Position position) {
		getSession().save(position);
	}

	@Override
	public void deleteById(int id) {
		Position position = (Position)getSession().get(Position.class, id);
		getSession().delete(position);		
	}

	@Override
	public void delete(Position position) {
		getSession().delete(position);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(Position.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(Position.class)
				.add(Restrictions.eq("isAvailable", true))
				.setMaxResults(offset)
				.setFirstResult(start)
				.addOrder(Order.desc("publishTime"))
				.list();
	}

	@Override
	public List getByCompanyId(int companyId) {
		return getSession()
				.createCriteria(Position.class)
				.add(Restrictions.eq("companyId", companyId))
				.addOrder(Order.desc("publishTime"))
				.list();
	}
}
