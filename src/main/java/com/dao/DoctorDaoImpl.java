package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.Contact;
import com.entities.Doctor;
import com.entities.Patient;
import com.services.ContactService;

public class DoctorDaoImpl extends MainDao implements DoctorDao {

	

	
	public Doctor getdoctor(int contact) {
//		doctor d= this.hibernateTemplate.get(doctor.class, email);
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Doctor.class);
		c.add(Restrictions.eq("contact", contact));
		Doctor d= (Doctor) c.uniqueResult();
		
		return d;
	}

	public Doctor getdoctorid(int id) {
		// TODO Auto-generated method stub
		Doctor d= this.hibernateTemplate.get(Doctor.class, id);
		
		return d;
	}

	
	
	
	
	@Transactional
	public int adddoctor(Doctor doctor) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(doctor);
		tx.commit();
		session.close();
		return 1;
	}

	public List<Doctor> getall() {
		List<Doctor> l= this.hibernateTemplate.loadAll(Doctor.class);
		return l;
	}

	public String doctorname(int id) {
		// TODO Auto-generated method stub
		Doctor d= this.hibernateTemplate.get(Doctor.class, id);
		String f_name= d.getFirst_name();
		String l_name= d.getLast_name();
		String name= f_name+" "+l_name;
		return name;
	}

	@Transactional
	public void deletedoctor(int id) {
		// TODO Auto-generated method stub
		Doctor d= getdoctorid(id);
		this.hibernateTemplate.delete(d);
	}
	
	

	



	


}
