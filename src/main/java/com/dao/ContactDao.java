package com.dao;

import java.util.List;

import com.entities.Contact;

public interface ContactDao {
	
	public void savecontact(Contact c);
	public Contact getcontactem(String em);
	public List<Contact> getall();
	public Contact getcontact(int id);
	public Contact getcontactbyemail(String em);
	public void deleteContact(String em);

}
