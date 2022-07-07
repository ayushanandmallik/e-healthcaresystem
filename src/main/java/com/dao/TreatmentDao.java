package com.dao;

import java.util.List;

import com.entities.Treatment;

public interface TreatmentDao {

	public void add(Treatment t);
	public List<Treatment> get_pat_treatment(int pid);
	public Treatment get(int id);
}
