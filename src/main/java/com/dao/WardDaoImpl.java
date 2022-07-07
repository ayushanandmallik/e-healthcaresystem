package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Department;
import com.entities.Ward;

public class WardDaoImpl extends MainDao implements WardDao {



	public Ward get(int id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Ward.class, id);
	}


	public List<Ward> getall() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(Ward.class);
	}


	@Transactional
	public void addward(Ward w) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(w);
		tx.commit();
		session.close();
	}



	public Ward getward(String name) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Ward.class);
		c.add(Restrictions.eq("ward", name));
		Ward w= (Ward) c.uniqueResult();
		return w;
	}

	
	
	

}
