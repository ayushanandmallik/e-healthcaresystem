package com.services;

import java.util.List;

import com.entities.Patient;
import com.entities.Users;

public interface UserService {
	public int registerUser(Users user);
	public Users getuser(String email);
	public int loginuser(String email, String pwd);
	public int changepwd(String email, String opwd, String npwd);
	public int forgotpwd(String email, String npwd);

}
