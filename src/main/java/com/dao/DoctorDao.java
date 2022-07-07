package com.dao;

import java.util.List;

import com.entities.Doctor;
import com.entities.Patient;

public interface DoctorDao {
	public Doctor getdoctor(int contact);
	public int adddoctor(Doctor doctor);
	public List<Doctor> getall();
	public String doctorname(int id);
	public Doctor getdoctorid(int id);
	public void deletedoctor(int id);
	
}
