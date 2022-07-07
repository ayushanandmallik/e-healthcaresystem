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

import com.entities.Department;

public class DepartmentDaoImpl extends MainDao implements DepartmentDao {

	@Transactional
	public void adddepartment(Department d) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(d);
		tx.commit();
		session.close();
		
	}
	public Department getdepartment(String name) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Department.class);
		c.add(Restrictions.eq("dept", name));
		Department d= (Department) c.uniqueResult();
		return d;
	}

	public List<Department> getalldepartment() {
		// TODO Auto-generated method stub
		List<Department> d= this.hibernateTemplate.loadAll(Department.class);
		return d;
	}
	public Department getdepartmentid(int id) {
		// TODO Auto-generated method stub
		
		return this.hibernateTemplate.get(Department.class, id);
	}
	@Transactional
	public void deletedepartment(String dept) {
		// TODO Auto-generated method stub
		Department d= getdepartment(dept);
		this.hibernateTemplate.delete(d);
		
	}

	
	
	
}
