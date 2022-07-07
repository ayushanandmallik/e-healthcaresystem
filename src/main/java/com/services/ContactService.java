package com.services;

import java.util.List;

import com.entities.Contact;

public interface ContactService {
	public int savecontact(Contact c);
	public Contact getcontactem(String em);
	public List<Contact> getall();
	public Contact getcontact(int id);
	public Contact getcontactbyemail(String email);

}
