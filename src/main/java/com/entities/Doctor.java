package com.entities;


import javax.persistence.*;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	private String last_name;
	private int department;
	private int contact;

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}






	public int getDepartment() {
		return department;
	}



	public void setDepartment(int department) {
		this.department = department;
	}



	public int getContact() {
		return contact;
	}



	public void setContact(int contact) {
		this.contact = contact;
	}



//	public doctor() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	

	
	
}
