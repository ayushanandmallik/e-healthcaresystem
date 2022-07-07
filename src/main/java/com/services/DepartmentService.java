package com.services;

import java.util.List;

import com.entities.Department;

public interface DepartmentService {
	public void adddepartment(Department d);
	public List<Department> getalldepartment();
	public Department getdepartment(String name);
	public Department getdepartmentid(int id);
}
