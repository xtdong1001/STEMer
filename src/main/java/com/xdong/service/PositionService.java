package com.xdong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdong.dao.PositionDao;
import com.xdong.model.Position;

@Service
@Transactional
public class PositionService implements IGenericService<Position> {

	PositionDao positionDao;

	@Autowired
	public void setCustomerDao(PositionDao positionDao) {
		this.positionDao = positionDao;
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
		positionDao.add(position);
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

}
