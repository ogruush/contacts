package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.model.User;
import com.util.IUserDB;
import com.dao.UserDao;

public class SignUpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(0, name, username, password);
		IUserDB db = new UserDao();
		
		db.addUser(user);
		
		out.println("You created successfully!!!");
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.include(request, response);
		
	}
}
