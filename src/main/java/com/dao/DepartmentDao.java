package com.dao;

import java.util.List;

import com.entities.Department;

public interface DepartmentDao {
	
	public void adddepartment(Department d);
	public List<Department> getalldepartment();
	public Department getdepartment(String name);
	public Department getdepartmentid(int id);
	public void deletedepartment(String dept);
}
