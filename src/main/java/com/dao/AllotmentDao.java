package com.dao;

import java.util.List;

import com.entities.Allotment;

public interface AllotmentDao {

	public Allotment add(Allotment a);
	public List<Allotment> getall();
	public List<Allotment> getbypat(int pid);
	public Allotment getbyid(int id);
//	public void delete(int pid);
//	
}
