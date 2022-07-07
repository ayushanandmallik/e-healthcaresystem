package com.dao;

import java.util.List;

import com.entities.Ward;

public interface WardDao {
	public Ward get(int id);
	public List<Ward> getall();
	public void addward(Ward w);
	public Ward getward(String name);
}
