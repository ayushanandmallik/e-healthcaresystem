package com.dao;

import java.util.List;

import org.hibernate.Criteria;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.entities.LabReports;

public class LabReportsDaoImpl extends MainDao implements LabReportsDao {


	
	@Transactional
	public void uploadreport(LabReports lab_report) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(lab_report);
//		sessionFactory.getCurrentSession().save(lab_report);
		tx.commit();
		session.close();
		
	}

	
	public LabReports getreportbypat(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(LabReports.class);
		c.add(Restrictions.eq("patient_id", id));
		LabReports l= (LabReports) c.uniqueResult();
		return l;
	}


	public LabReports getreport(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		LabReports l= this.hibernateTemplate.get(LabReports.class, id);
		return l;
	}


	public List<LabReports> allreports() {
		// TODO Auto-generated method stub
		List<LabReports> r= this.hibernateTemplate.loadAll(LabReports.class);
		return r;
	}


	public List<LabReports> getallreportbypat(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(LabReports.class);
		c.add(Restrictions.eq("patient_id", id));
		List<LabReports> l= c.list();
		return l;
	}
	
}
