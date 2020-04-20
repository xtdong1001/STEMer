package com.xdong.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xdong.model.Company;

@Repository
public class CompanyDao implements IGenericDao<Company>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAll() {
		Criteria criteria = getSession().createCriteria(Company.class);
		return (List)criteria.list();
	}

	@Override
	public Company getById(int id) {
		Company company = (Company)getSession().get(Company.class, id);
		company.getPositions().size();
		return company;
	}

	@Override
	public void saveOrUpdate(Company company) {
		getSession().saveOrUpdate(company);
	}

	@Override
	public void add(Company company) {
		getSession().save(company);
	}

	@Override
	public void deleteById(int id) {
		Company company = (Company)getSession().get(Company.class, id);
		getSession().delete(company);		
	}

	@Override
	public void delete(Company company) {
		getSession().delete(company);	
	}

	@Override
	public int getCount() {
		Long count =  (Long)getSession()
				.createCriteria(Company.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return getSession()
				.createCriteria(Company.class)
				.setMaxResults(offset)
				.setFirstResult(start)
				.list();
	}

	@Override
	public List search(String key) {
		return getSession()
				.createCriteria(Company.class)
				.add(Restrictions.or(Restrictions.ilike("name", key, MatchMode.ANYWHERE), Restrictions.ilike("description", key, MatchMode.ANYWHERE), Restrictions.ilike("industry", key, MatchMode.ANYWHERE)))
				.list();
	}
}
