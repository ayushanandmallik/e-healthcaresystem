package com.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allotment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int pid;
	private Integer ward;
	private Integer bed;
	private LocalDateTime time;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getWard() {
		return ward;
	}
	public void setWard(int ward) {
		this.ward = ward;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Allotment(int id, int pid, Integer ward, Integer bed, LocalDateTime time) {
		super();
		this.id = id;
		this.pid = pid;
		this.ward = ward;
		this.bed = bed;
		this.time = time;
	}
	public Allotment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
