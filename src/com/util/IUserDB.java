package com.util;

import com.model.User;

public interface IUserDB {
	public User checkUser(User user);
	public void addUser(User user); 
}
