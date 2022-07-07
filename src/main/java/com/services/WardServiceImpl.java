package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.WardDao;
import com.entities.Ward;

@Service
@Primary
public class WardServiceImpl implements WardService {

	@Autowired
	private WardDao wardDao;
	
	public void setWardDao(WardDao wardDao) {
		this.wardDao= wardDao;
	}

	public Ward get(int id) {
		// TODO Auto-generated method stub
		return this.wardDao.get(id);
	}

	public List<Ward> getall() {
		// TODO Auto-generated method stub
		return wardDao.getall();
	}

	public void addward(Ward w) {
		// TODO Auto-generated method stub
		wardDao.addward(w);
	}

	public Ward getward(String name) {
		// TODO Auto-generated method stub
		return wardDao.getward(name);
	}

}
