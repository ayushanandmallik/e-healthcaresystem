package com.services;

import java.util.List;

import com.entities.Allotment;

public interface AllotmentService {
	
	public Allotment add(Allotment a);
	public List<Allotment> getall();
	public List<Allotment> getbypat(int pid);
	public Allotment getbyid(int id);
	public Allotment getlatest(int pid);
//	public void delete(int pid);
//	public void update(Allotment a, int pid);

}
