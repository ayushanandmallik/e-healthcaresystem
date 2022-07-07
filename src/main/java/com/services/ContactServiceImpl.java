package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.ContactDao;
import com.entities.Contact;

@Service
@Primary
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao= contactDao;
	}


	public int savecontact(Contact c) {
		// TODO Auto-generated method stub
		int j=0;
		Contact c1= getcontactbyemail(c.getEmail());
		if(c1==null) {
			contactDao.savecontact(c);
			j=1;
			return j;
		}
		return j;
		//contactDao.savecontact(c);
		
	}

	public Contact getcontactem(String em) {
		// TODO Auto-generated method stub
		Contact c= contactDao.getcontactem(em);
		return c;
	}


	public List<Contact> getall() {
		// TODO Auto-generated method stub
		return contactDao.getall();
	}


	public Contact getcontact(int id) {
		// TODO Auto-generated method stub
		return contactDao.getcontact(id);
	}


	public Contact getcontactbyemail(String email) {
		// TODO Auto-generated method stub
		Contact c= contactDao.getcontactbyemail(email);
		return c;
	}
}
