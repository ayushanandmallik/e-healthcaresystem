package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	@NotNull
	@Column
	private String first_name;

	@NotNull
	@Column
	private String last_name;

	@NotNull
	@Column
	private int contact;

	@Column
	private Integer doctor;



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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



	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Integer getDoctor() {
		return doctor;
	}

	public void setDoctor(Integer doctor) {
		this.doctor = doctor;
	}

//	public patient() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

}
