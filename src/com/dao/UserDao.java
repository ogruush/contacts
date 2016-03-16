package com.dao;

import java.sql.*;
import com.model.User;
import com.util.DBConnection;
import com.util.IUserDB;


public class UserDao implements IUserDB{
	
	private Connection connection;
	private PreparedStatement statement;
	
	public UserDao(){
		connection = DBConnection.getConnection();
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		User  tos = null;
		try {
			statement = connection.prepareStatement(("SELECT * FROM user WHERE username=? AND password=? ")) ;
			statement.setString(1, user.getUsername());
	        statement.setString(2, user.getPassword());
	        ResultSet resultSet =statement.executeQuery();
	       
	        while(resultSet.next()){
	            User finduser = new User(0, "", "","")  ;
	            finduser.setUserid(resultSet.getInt(1));
	            finduser.setName(resultSet.getString(2));
	            finduser.setUsername(resultSet.getString(3));
	            finduser.setPassword(resultSet.getString(4));
	            tos=finduser;
	        }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return tos;

	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement("INSERT INTO user " +
                    "VALUES (?,?, ?, ?)");
			
			statement.setInt(1, user.getUserid());
			statement.setString(2, user.getName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
