package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.xdong.dao.PositionDao;
import com.xdong.model.Position;
import com.xdong.validator.ApplicationValidator;
import com.xdong.validator.PositionValidator;

@Service
@Transactional
public class PositionService implements IPositionService<Position> {
	PositionDao positionDao;
	PositionValidator positionValidator;

	@Autowired
	public void setCustomerDao(PositionDao positionDao, PositionValidator positionValidator) {
		this.positionDao = positionDao;
		this.positionValidator = positionValidator;
	}

	@Override
	public List<Position> getAll() {
		return positionDao.getAll();
	}

	@Override
	public Position getById(int id) {
		return positionDao.getById(id);
	}

	@Override
	public void saveOrUpdate(Position position) {
		positionDao.saveOrUpdate(position);
	}

	@Override
	public void deleteById(int id) {
		positionDao.deleteById(id);
	}

	@Override
	public void add(Position position) {
  	}

	@Override
	public void delete(Position position) {
		positionDao.delete(position);
	}

	@Override
	public int getCount() {
		return positionDao.getCount();
	}

	@Override
	public List getAllLimit(int start, int offset) {
		return positionDao.getAllLimit(start, offset);
	}

	@Override
	public List getByCompanyId(int companyId) {
		return positionDao.getByCompanyId(companyId);
	}

	@Override
	public void validate(Object target, Errors errors) {
		positionValidator.validate(target, errors);
	}

}
