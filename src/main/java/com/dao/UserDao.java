package com.dao;

import java.util.List;

import com.entities.Users;

public interface UserDao {
	
	public int registerUser(Users user);
	public Users getuser(String email);
	public int loginuser(String email, String pwd);
	public void changepwd(int id, String pwd);
}
