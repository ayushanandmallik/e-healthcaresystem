package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entities.Patient;
import com.entities.Users;

@Service
@Primary
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao= userDao;
	}
	
	public int registerUser(Users user) {
		// TODO Auto-generated method stub
		int i= userDao.registerUser(user);
		return i;

	}

	public Users getuser(String email) {
		// TODO Auto-generated method stub
		Users u= userDao.getuser(email);
		return u;
	}

	public int loginuser(String email, String pwd) {
		// TODO Auto-generated method stub
		int i= userDao.loginuser(email, pwd);
		return i;
	}

	public int changepwd(String email, String opwd, String npwd) {
		// TODO Auto-generated method stub
		Users u= userDao.getuser(email);
		if(u==null) {
			return 0;
		}
		
		String oldpwd= u.getPassword();
		if(oldpwd.compareTo(opwd)!=0) {
			return 0;
		}
		int id= u.getId();
		userDao.changepwd(id, npwd);
		return 1;
		
	}

	public int forgotpwd(String email, String npwd) {
		// TODO Auto-generated method stub
		Users u= userDao.getuser(email);
		if(u==null) {
			return 0;
		}
		int id= u.getId();
		userDao.changepwd(id, npwd);
		return 1;
	}


	

	


	


}
