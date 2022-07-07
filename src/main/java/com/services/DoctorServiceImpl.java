package com.services;

import java.util.List;
import com.dao.ContactDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.entities.Contact;
import com.entities.Doctor;
import com.dao.DoctorDao;
import com.services.*;

@Service
@Primary
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ContactDao contactDao;
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao= contactDao;
	}

	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	public Doctor getdoctor(String email) {
		Contact c= contactDao.getcontactbyemail(email);
		int cid= c.getId();
		Doctor d = doctorDao.getdoctor(cid);
		return d;
	}

	public void adddoctor(Doctor doctor) {
		doctorDao.adddoctor(doctor);
	}

	public List<Doctor> getall() {
		List<Doctor> l = doctorDao.getall();
		return l;
	}

	public String doctorname(int id) {
		// TODO Auto-generated method stub
		String name = doctorDao.doctorname(id);
		return name;
	}

	public Doctor getdoctorid(int id) {
		// TODO Auto-generated method stub
		Doctor d = doctorDao.getdoctorid(id);
		return d;
	}



}
