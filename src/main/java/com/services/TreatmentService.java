package com.services;

import java.util.List;

import com.entities.Treatment;

public interface TreatmentService {
	public void add(Treatment t);
	public List<Treatment> get_pat_treatment(int pid);
	public Treatment get(int id);
	public	Treatment latest(int pid);
}
