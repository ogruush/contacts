package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/phonedirapp", "root", "");
			return conn;
		}catch(Exception ex){
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}
	
	public static void close(Connection conn){
		try{
			conn.close();
		}catch(Exception ex){
			
		}
	}
}
