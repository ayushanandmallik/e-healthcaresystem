package com.services;

import com.entities.Contact;
import com.entities.Patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.PatientDao;
import com.dao.UserDao;
import com.dao.ContactDao;
import com.services.*;

@Service
@Primary
public class PatientServiceImpl implements PatientService {

	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private ContactDao contactDao;
	
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao= patientDao;
	}
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao= contactDao;
	}
	
	
	public Patient getpatient(String email) {
		Contact c= contactDao.getcontactbyemail(email);
		if(c==null) {
			return null;
		}
		int cid= c.getId();
		Patient p= patientDao.getpatient(cid);
		return p;
	}

	public int addpatient(Patient patient) {
		// TODO Auto-generated method stub
		int i= patientDao.addpatient(patient);
		return i;
	}



	public List<Patient> getall() {
		// TODO Auto-generated method stub
		List<Patient> l= patientDao.getall();
		return l;
	}



	public List<Patient> docpat(int id) {
		// TODO Auto-generated method stub
		List<Patient> p= patientDao.docpat(id);
		return p;
	}



	public Patient getpatientid(int id) {
		// TODO Auto-generated method stub
		Patient p= patientDao.getpatientid(id);
		return p;
	}


//
//	public int updatepatient(int id, String symptoms, String disease, String ward, String bed, String pres) {
//		// TODO Auto-generated method stub
//		int i= patientDao.updatepatient(id, symptoms, disease, ward, bed, pres);
//		return i;
//	}



	public void updatepatientdoctor(int id, Integer doctor) {
		// TODO Auto-generated method stub
		patientDao.updatepatientdoctor(id, doctor);
		
	}

}
