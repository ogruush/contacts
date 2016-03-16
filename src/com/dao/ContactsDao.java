package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnection;
import com.util.IContactDB;
import com.model.Contacts;
import com.model.User;
import com.util.IUserDB;

public class ContactsDao implements IContactDB{
	
	private Connection connection;
	private PreparedStatement statement;
	
	public ContactsDao(){
		connection = DBConnection.getConnection();
	}

	@Override
	public List<Contacts> getAllContacts(int userid) {
		// TODO Auto-generated method stub
		List<Contacts> contactList = new ArrayList<Contacts>();
        try {
            statement = connection.prepareStatement(("SELECT * FROM contacts WHERE userid=? ")) ;
			statement.setInt(1, userid);

	        ResultSet rs =statement.executeQuery();
            while (rs.next()) {
                Contacts contacts = new Contacts(0, "", "", "", "");
                contacts.setUserid(rs.getInt("userid"));
                contacts.setName(rs.getString("name"));
                contacts.setPhone(rs.getString("phone"));
                contacts.setEmail(rs.getString("email"));
                contacts.setMemo(rs.getString("memo"));
                contactList.add(contacts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return contactList;

	}

	@Override
	public void addContact(Contacts contact) {
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement("INSERT INTO contacts " +
                    "VALUES (?, ?, ?, ?, ?)");
			
			statement.setInt(1, contact.getUserid());
			statement.setString(2, contact.getName());
			statement.setString(3, contact.getPhone());
			statement.setString(4, contact.getEmail());
			statement.setString(5, contact.getMemo());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean deleteContact(Contacts contact){
		try {
			statement = connection.prepareStatement("DELETE FROM contacts WHERE userid=? AND name=?" );

			statement.setInt(1, contact.getUserid());
			statement.setString(2, contact.getName());
			
			statement.executeUpdate();
			return true;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		
	}

	@Override
	public boolean updateContact(Contacts contact, String searchName) {
		// TODO Auto-generated method stub
		try{
			statement = connection.prepareStatement("UPDATE contacts SET name=?, phone=?, email=?, memo=? WHERE userid=? AND name=?" );
			
			statement.setString(1, contact.getName());
			statement.setString(2, contact.getPhone());
			statement.setString(3, contact.getEmail());
			statement.setString(4, contact.getMemo());
			statement.setInt(5, contact.getUserid());
			statement.setString(6, searchName);
			
			statement.executeUpdate();
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Contacts searchContacts(Contacts contact) {
		// TODO Auto-generated method stub
		Contacts  tos = null;
		try {
        	
        	statement = connection.prepareStatement("SELECT * FROM contacts WHERE userid=? AND name=?" );
			
			statement.setInt(1, contact.getUserid());
			statement.setString(2, contact.getName());

			ResultSet rs =statement.executeQuery();
 
            if (rs.next()) {
            	Contacts temp = new Contacts(0, "", "", "", "");
            	temp.setUserid(rs.getInt("userid"));
            	temp.setName(rs.getString("name"));
            	temp.setPhone(rs.getString("phone"));
            	temp.setEmail(rs.getString("email"));
            	temp.setMemo(rs.getString("memo"));
            	tos = temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return tos;

	}

}
