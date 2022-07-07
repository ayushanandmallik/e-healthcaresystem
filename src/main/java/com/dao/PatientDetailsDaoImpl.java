package com.dao;

import java.util.List;

//import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.PatientDetails;
import com.services.PatientDetailsService;

public class PatientDetailsDaoImpl extends MainDao implements PatientDetailsDao {

	
	@Transactional
	public void add_patient_details(PatientDetails patient_details) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(patient_details);
		
	}

	public PatientDetails get_patient_details(int pid) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(PatientDetails.class);
		c.add(Restrictions.eq("pid", pid));
		PatientDetails d= (PatientDetails) c.uniqueResult();
		return d;
	}

	public PatientDetails getdet(int id) {
		// TODO Auto-generated method stub
		PatientDetails p= this.hibernateTemplate.get(PatientDetails.class, id);
		return p;
	}
	
	@Transactional
	public void updatestatus(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		PatientDetails p= getdet(id);
		Integer st= p.getStatus();
		if(st==0) {
			p.setStatus(1);
			tx.commit();
			session.close();
		}
		else {
//			p.setBed(null);
//			p.setDisease(null);
//			p.setPrescription(null);
//			p.setSymptoms(null);
	//		p.setWard(null);
			p.setStatus(0);
			tx.commit();
			session.close();
		}
		
	}

	public List<PatientDetails> getall() {
		// TODO Auto-generated method stub
		List<PatientDetails> l= this.hibernateTemplate.loadAll(PatientDetails.class);
		return l;
	}

	@Transactional
	public void updatepatdet(int pid, PatientDetails pd) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		PatientDetails pd1= get_patient_details(pid);
		session.evict(pd1);
//		pd1.setBed(pd.getBed());
//		pd1.setDisease(pd.getDisease());
//		pd1.setPrescription(pd.getPrescription());
//		pd1.setSymptoms(pd.getSymptoms());
		pd1.setBloodgroup(pd.getBloodgroup());
	//	pd1.setWard(pd.getWard());
		session.update(pd1);
		tx.commit();
		session.close();
		
	}

}
