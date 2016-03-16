package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.User;
import com.util.IUserDB;
import com.dao.UserDao;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(0, "", username, password);
		IUserDB db = new UserDao();
		User result = db.checkUser(user);
		
		HttpSession session = request.getSession();
	    		
		String button_param = request.getParameter("button");
		if(button_param.equals("Login")){
			if(result != null){
				int id = result.getUserid();
			    session.setAttribute("userid", id);
				RequestDispatcher rs = request.getRequestDispatcher("view/main.jsp");
				rs.forward(request, response);
			}else{
				out.println("Username or password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
				rs.include(request, response);
			}
		}else{
			RequestDispatcher rs = request.getRequestDispatcher("view/signup.jsp");
			rs.forward(request, response);
		}
		
	}
	
	

}

