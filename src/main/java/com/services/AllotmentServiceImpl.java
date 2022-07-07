package com.services;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.entities.Allotment;

@Service
@Primary
public class AllotmentServiceImpl implements AllotmentService{

	@Autowired
	private AllotmentDao allotmentDao;
	
	public void setAllotmentDao(AllotmentDao allotmentDao) {
		this.allotmentDao= allotmentDao;
	}

	public Allotment add(Allotment a) {
		// TODO Auto-generated method stub
		
		return allotmentDao.add(a);
		
	}
	
	

	public List<Allotment> getall() {
		// TODO Auto-generated method stub
		return allotmentDao.getall();
	}

	public List<Allotment> getbypat(int pid) {
		// TODO Auto-generated method stub
		List<Allotment> a= allotmentDao.getbypat(pid);
		return a;
	}

	public Allotment getbyid(int id) {
		// TODO Auto-generated method stub
		return allotmentDao.getbyid(id);
	}

	public Allotment getlatest(int pid) {
		// TODO Auto-generated method stub
		List<Allotment> a= getbypat(pid);
		if(a.size()==0) {
			return null;
		}
		Allotment a1= a.get(a.size()-1);
		return a1;
	}


	
}
