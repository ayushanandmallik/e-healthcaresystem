package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.services.ContactService;

public class MainDao {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected ContactService contactService;
	
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	public void setsessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
	}
}
