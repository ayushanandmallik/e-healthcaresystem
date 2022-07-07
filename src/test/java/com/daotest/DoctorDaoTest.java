package com.daotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ContactDao;
import com.dao.DoctorDao;
import com.entities.Contact;
import com.entities.Doctor;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class DoctorDaoTest {

	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private ContactDao contactDao;
	
	@Before
	public void before() {
		Contact c= new Contact();
		c.setEmail("test@test.com");
		c.setPhone_no("123");
		contactDao.savecontact(c);
		Doctor d= new Doctor();
		d.setFirst_name("Test");
		d.setLast_name("Test");
		d.setDepartment(1);
		Contact c1= contactDao.getcontactbyemail("test@test.com");
		d.setContact(c1.getId());
		doctorDao.adddoctor(d);
	}
	
	@Test
	public void testGetAll() {
		List<Doctor> l= doctorDao.getall();
		assertTrue(l.size()>0);
	}
	
	@Test
	public void testGetByContact() {
		Contact c= contactDao.getcontactbyemail("test@test.com");
		Doctor d= doctorDao.getdoctor(c.getId());
		assertNotNull(d);
	}
	
	@Test
	public void testGetDoctorName() {
		Contact c= contactDao.getcontactbyemail("test@test.com");
		Doctor d= doctorDao.getdoctor(c.getId());
		String name= doctorDao.doctorname(d.getId());
		String exp= d.getFirst_name()+" "+d.getLast_name();
		assertEquals(name, exp);
	}
	
	@After
	public void after() {
		Contact c= contactDao.getcontactbyemail("test@test.com");
		int id= doctorDao.getdoctor(c.getId()).getId();
		doctorDao.deletedoctor(id);
		contactDao.deleteContact("test@test.com");
	}
	
}
