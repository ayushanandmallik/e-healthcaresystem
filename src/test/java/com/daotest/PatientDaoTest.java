package com.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ContactDao;
import com.dao.ContactDaoImpl;
import com.dao.PatientDao;
import com.dao.PatientDaoImpl;
import com.entities.Contact;
import com.entities.Patient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class PatientDaoTest {

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private ContactDao contactDao;
	
	@Before
	public void setup() {
		Contact c= new Contact();
		c.setEmail("test@test.com");
		c.setPhone_no("123");
		contactDao.savecontact(c);
		Patient p= new Patient();
		p.setDoctor(1);
		p.setFirst_name("Test");
		p.setLast_name("Test");
		int cid= contactDao.getcontactbyemail("test@test.com").getId();
		p.setContact(cid);
		patientDao.addpatient(p);
	}
	
	@Test
	public void testGetAllPatient(){
		List<Patient> l= patientDao.getall();
		assertTrue(l.size()>0);
	}
	
	@Test
	public void testGetPatientbyContact() {
		Contact c= contactDao.getcontactbyemail("test@test.com");
		Patient p= patientDao.getpatient(c.getId());
		assertNotNull(p);
	}
	@Test
	public void testGetPatientsbyDoctor() {
		List<Patient> l= patientDao.docpat(1);
		assertTrue(l.size()>0);
	}
	
	@Test
	public void testGestPatientbyId() {
		Patient p= patientDao.getpatientid(1);
		assertNotNull(p);
	}
	
	
	@After
	public void after() {
		Contact c= contactDao.getcontactbyemail("test@test.com");
		Patient p= patientDao.getpatient(c.getId());
		patientDao.deletepatient(p.getPid());
		contactDao.deleteContact("test@test.com");
		
	}
	
	

}
