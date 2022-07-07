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

import com.entities.Contact;

public class ContactDaoImpl extends MainDao implements ContactDao {



	@Transactional
	public void savecontact(Contact c) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		this.hibernateTemplate.save(c);
		tx.commit();
		session.close();
	}


	public Contact getcontactem(String ph) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Contact.class);
		c.add(Restrictions.eq("phone_no", ph));
		Contact contact= (Contact) c.uniqueResult();
		return contact;
	}


	public List<Contact> getall() {
		// TODO Auto-generated method stub
		List<Contact> c= this.hibernateTemplate.loadAll(Contact.class);
		return c;
	}


	public Contact getcontact(int id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Contact.class, id);
	}


	public Contact getcontactbyemail(String em) {
		Session session= sessionFactory.openSession();
		Criteria c= session.createCriteria(Contact.class);
		c.add(Restrictions.eq("email", em));
		Contact contact= (Contact) c.uniqueResult();
		return contact;
	}


	@Transactional
	public void deleteContact(String em) {
		// TODO Auto-generated method stub
		Contact c= getcontactbyemail(em);
		this.hibernateTemplate.delete(c);
		
		
	}
}
