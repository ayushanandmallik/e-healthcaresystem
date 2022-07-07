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

import com.dao.DepartmentDao;
import com.entities.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class DepartmentDaoTest {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Before
	public void before() {
		Department d= new Department();
		d.setDept("Eyes");
		departmentDao.adddepartment(d);	
	}
	
//	@Test
//	public void testAddDepartment() {
//		Department d= new Department();
//		d.setDept("Eyes");
//		departmentDao.adddepartment(d);	
//	}
	
	@Test
	public void testGetDepartment() {
		Department d= departmentDao.getdepartment("Eyes");
		assertNotNull(d);
	}
	
	@Test
	public void testGetAll() {
		List<Department> d= departmentDao.getalldepartment();
		assertTrue(d.size()>0);
	}
	
	@Test
	public void testGetById() {
		Department d= departmentDao.getdepartmentid(1);
		assertNotNull(d);
	}
	
	@After
	public void after() {
		departmentDao.deletedepartment("Eyes");
	}
}
