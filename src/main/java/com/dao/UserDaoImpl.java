package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;

//import javax.persistence.Query;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.Users;

public class UserDaoImpl extends MainDao implements UserDao {


	
	
	public Users getuser(String email) {
		Session session= sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria c= session.createCriteria(Users.class);
		c.add(Restrictions.eq("email", email));
		Users u= (Users) c.uniqueResult();
		return u;
	}
	
	@Transactional
	public int registerUser(Users user) {

		Session session= sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String em= user.getEmail();
		Users u1= getuser(em);
		int j=0;
		if(u1!=null) {
			tx.commit();
			session.close();
			return j;
		}
		else {
			j=1;
			this.hibernateTemplate.save(user);
			tx.commit();
			session.close();
			return j;
		}
		
	}


	public int loginuser(String email, String pwd) {
		// TODO Auto-generated method stub
		Users u1= getuser(email);
		int j=0;
		
		if(u1==null) {
			j=2;
			return j;
		}
		else {
			if(u1.getPassword().equals(pwd)) {
				j=1;
				return j;
			}
			else {
				return j;
			}
		}
		
	}
	
	@Transactional
	public void changepwd(int id, String pwd) {
//		Session session= sessionFactory.openSession();
//		Transaction tx= session.getTransaction();
		Users u= this.hibernateTemplate.get(Users.class, id);
		u.setPassword(pwd);
		this.hibernateTemplate.update(u);
		//tx.commit();
//		session.close();
		
	}




}




