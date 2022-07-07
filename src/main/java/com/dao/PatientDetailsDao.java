package com.dao;

import java.util.List;

import com.entities.PatientDetails;

public interface PatientDetailsDao {

	public void add_patient_details(PatientDetails patient_details);
	public PatientDetails get_patient_details(int pid);
	public void updatestatus(int id);
	public PatientDetails getdet(int id);
	public List<PatientDetails> getall();
	public void updatepatdet(int pid, PatientDetails pd);
	
}
