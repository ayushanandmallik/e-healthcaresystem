package com.services;

import java.util.List;

import com.entities.Doctor;

public interface DoctorService {
	public Doctor getdoctor(String email);
	public void adddoctor(Doctor doctor);
	public List<Doctor> getall();
	public String doctorname(int id);
	public Doctor getdoctorid(int id);
}
