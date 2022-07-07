package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.PatientDetailsDao;
import com.entities.PatientDetails;

@Service
@Primary
public class PatientDetailsServiceImpl implements PatientDetailsService {

	@Autowired
	private PatientDetailsDao patient_detailsDao;
	
	public void setPatientDetailsDao(PatientDetailsDao patient_detailsDao) {
		this.patient_detailsDao= patient_detailsDao;
	}

	public void add_patient_details(PatientDetails patient_details) {
		// TODO Auto-generated method stub
		patient_detailsDao.add_patient_details(patient_details);
		
	}

	public PatientDetails get_patient_details(int pid) {
		// TODO Auto-generated method stub
		PatientDetails d= patient_detailsDao.get_patient_details(pid);
		return d;
	}

	public void updatestatus(int id) {
		// TODO Auto-generated method stub
		patient_detailsDao.updatestatus(id);
		
	}

	public PatientDetails getdet(int id) {
		// TODO Auto-generated method stub
		PatientDetails p= patient_detailsDao.getdet(id);
		return p;
	}

	public List<PatientDetails> getall() {
		// TODO Auto-generated method stub
		List<PatientDetails> l= patient_detailsDao.getall();
		return l;
	}

	public void updatepatdet(int pid, PatientDetails pd) {
		// TODO Auto-generated method stub
		patient_detailsDao.updatepatdet(pid, pd);
		
	}
	
}
