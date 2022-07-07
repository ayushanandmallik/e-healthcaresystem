package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDao;
import com.entities.Department;

@Service
@Primary
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao= departmentDao;
	}


	public void adddepartment(Department d) {
		// TODO Auto-generated method stub
		departmentDao.adddepartment(d);
		
	}


	public List<Department> getalldepartment() {
		// TODO Auto-generated method stub
		List<Department> d= departmentDao.getalldepartment();
		return d;
	}


	public Department getdepartment(String name) {
		// TODO Auto-generated method stub
		Department d= departmentDao.getdepartment(name);
		return d;
	}


	public Department getdepartmentid(int id) {
		// TODO Auto-generated method stub
		return departmentDao.getdepartmentid(id);
	}
	
	
}
