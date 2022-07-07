package com.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.Contact;
import com.entities.Patient;
import com.services.ContactService;

public class PatientDaoImpl extends MainDao implements PatientDao {

	

	
	
	
	public Patient getpatientid(int id) {
		// TODO Auto-generated method stub
		Patient p= this.hibernateTemplate.get(Patient.class, id);
		return p;
	}
	
	public Patient getpatient(int contact) {
		// TODO Auto-generated method stub
//		patient p= this.hibernateTemplate.get(patient.class, email);
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Patient.class);
		c.add(Restrictions.eq("contact", contact));
		Patient p= (Patient) c.uniqueResult();
	
		return p;
	}

	@Transactional
	public int addpatient(Patient patient) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(patient);
		
		tx.commit();
		session.close();
		return 1;
		
	}



	public List<Patient> getall() {
		// TODO Auto-generated method stub
		List<Patient> l= this.hibernateTemplate.loadAll(Patient.class);
		return l;
		
	}



	public List<Patient> docpat(int id) {
		// TODO Auto-generated method stub
		
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Patient.class);
		c.add(Restrictions.eq("doctor", id));
		
		List<Patient> p= (List<Patient>) c.list();
		
		
		
		return p;
	}





	@Transactional
	public void updatepatientdoctor(int id, Integer doctor) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Patient p= getpatientid(id);
		session.evict(p);
		p.setDoctor(doctor);
		session.update(p);
		tx.commit();
		session.close();
		
		
	}

	@Transactional
	public void deletepatient(int id) {
		// TODO Auto-generated method stub
		Patient p= getpatientid(id);
		this.hibernateTemplate.delete(p);
	}



	



}
