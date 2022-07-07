package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.entities.Allotment;

public class AllotmentDaoImpl extends MainDao implements AllotmentDao {

	@Transactional
	public Allotment add(Allotment a) {
		// TODO Auto-generated method stub
		try {
		Session session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(a);
		tx.commit();
		session.close();
		return a;
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public List<Allotment> getall() {
		// TODO Auto-generated method stub
		List<Allotment> l= this.hibernateTemplate.loadAll(Allotment.class);
		return l;
	}

	public List<Allotment> getbypat(int pid) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Allotment.class);
		c.add(Restrictions.eq("pid", pid));
		List<Allotment> a= c.list();
		return a;
	}

	public Allotment getbyid(int id) {
		// TODO Auto-generated method stub
		Allotment a= this.hibernateTemplate.get(Allotment.class, id);
		return a;
	}

	

//	@Transactional
//	public void delete(int pid) {
//		// TODO Auto-generated method stub
//		Session session= sessionFactory.openSession();
//		Transaction tx= session.beginTransaction();
//		Query q= session.createQuery("delete from allotment where pid=:pid");
//		q.setParameter("pid", pid);
//		q.executeUpdate();
//		tx.commit();
//		session.close();
//		
//	}

//	@Transactional
//	public void update(Allotment a, int pid) {
//		Session session = sessionFactory.openSession();
//		Transaction tx= session.beginTransaction();
//		Allotment a1= getbypat(pid);
//		a1.setBed(a.getBed());
//		a1.setWard(a.getWard());
//		tx.commit();
//		session.close();
//	}
//	
	

}
