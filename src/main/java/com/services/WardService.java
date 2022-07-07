package com.services;

import java.util.List;

import com.entities.Ward;

public interface WardService {
	public Ward get(int id);
	public List<Ward> getall();
	public void addward(Ward w);
	public Ward getward(String name);
}
