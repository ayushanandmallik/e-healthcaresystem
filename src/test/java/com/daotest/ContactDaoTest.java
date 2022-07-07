package com.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ContactDao;
import com.entities.Contact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class ContactDaoTest {

	@Autowired
	private ContactDao contactDao;
	
	@Before
	public void before() {
		Contact c= new Contact();
		c.setEmail("test@test.com");
		c.setPhone_no("123");
		contactDao.savecontact(c);
	}
	
//	@Test
//	public void testSaveContact() {
//		Contact c= new Contact();
//		c.setEmail("test@test.com");
//		c.setPhone_no("123");
//		contactDao.savecontact(c);
//	}
	
	@Test
	public void testGetcontactbyphone() {
		Contact c= contactDao.getcontactem("123");
		assertNotNull(c);
	}
	
	@Test
	public void testGetall() {
		List<Contact> l= contactDao.getall();
		assertTrue(l.size()>0);
	}
	
	@Test
	public void testGetbyId() {
		Contact c= contactDao.getcontact(1);
		assertNotNull(c);
	}
	
	@Test
	public void testGetByEmail() {
		Contact c= contactDao.getcontactbyemail("test@test.com");
		assertNotNull(c);
	}
	
	
	@After
	public void after() {
		contactDao.deleteContact("test@test.com");
	}
}
