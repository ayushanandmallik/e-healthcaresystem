package com.daotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.AllotmentDao;
import com.entities.Allotment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class AllotmentDaoTest {
	
	@Autowired
	private AllotmentDao allotmentDao;
	
	@Test
	public void testAdd(){
		Allotment a= new Allotment(1, 1, 1, 1, LocalDateTime.now());
		
		Allotment a1= allotmentDao.add(a);
		assertEquals(a1, a);
	}
	
	@Test
	public void testGetall() {
		List<Allotment> l= allotmentDao.getall();
		assertTrue(l.size()>0);
	}
	
	@Test
	public void testGetbypat() {
		List<Allotment> l= allotmentDao.getall();
		for(Allotment a: l) {
			List<Allotment> a1= allotmentDao.getbypat(a.getPid());
			assertTrue(a1.size()>0);
		}
	}
	
	@Test
	public void testGetbyid() {
		List<Allotment> l= allotmentDao.getall();
		for(Allotment a:l) {
			Allotment a1= allotmentDao.getbyid(a.getId());
			assertNotNull(a1);
		}
		
	}
}
