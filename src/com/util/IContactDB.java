package com.util;

import java.util.List;
import com.model.Contacts;
import com.model.User;

public interface IContactDB {

	public List<Contacts> getAllContacts(int userid);
	public void addContact(Contacts contact);
	public boolean deleteContact(Contacts contact);
	public boolean updateContact(Contacts contact, String name);
	public Contacts searchContacts(Contacts contact);
	
}
