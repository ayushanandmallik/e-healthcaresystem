package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.Treatment;
import com.services.ContactService;

public class TreatmentDaoImpl extends MainDao implements TreatmentDao {

	@Transactional
	public void add(Treatment t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
		
	}

	public List<Treatment> get_pat_treatment(int pid) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		//Transaction tx= session.beginTransaction();
		Criteria c= session.createCriteria(Treatment.class);
		c.add(Restrictions.eq("pid", pid));
		List<Treatment> t= c.list();
		return t;
	}

	public Treatment get(int id) {
		// TODO Auto-generated method stub
		Treatment t= this.hibernateTemplate.get(Treatment.class, id);
		return t;
	}
}
