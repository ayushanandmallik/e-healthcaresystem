package com.dao;

import java.util.List;

import com.entities.Patient;

public interface PatientDao {

	public Patient getpatient(int contact);
	public int addpatient(Patient patient);
	public List<Patient> getall();
	public List<Patient> docpat(int id);
	public Patient getpatientid(int id);
//	public int updatepatient(int id, String symptoms, String disease, String ward, String bed, String pres);
	public void updatepatientdoctor(int id, Integer doctor);
	public void deletepatient(int id);
}
