package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Contacts;
import com.util.IContactDB;
import com.dao.ContactsDao;

public class AddContactServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int userid = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String memo = request.getParameter("memo");
		
		Contacts contact = new Contacts(userid, name, phone, email, memo);
		IContactDB db = new ContactsDao();
		
		String button_param = request.getParameter("button");
		if(button_param.equals("Add")){
			db.addContact(contact);
			
			out.println("You add contact");
			
			request.setAttribute("name", " ");
			request.setAttribute("phone", " ");
			request.setAttribute("email", " ");
			request.setAttribute("memo", " ");
			
			RequestDispatcher rs = request.getRequestDispatcher("view/addContact.jsp");
			rs.include(request, response);
		}else if(button_param.equals("Back")){
			RequestDispatcher rs = request.getRequestDispatcher("view/main.jsp");
			rs.forward(request, response);
		}else{
			request.setAttribute("name", " ");
			request.setAttribute("phone", " ");
			request.setAttribute("email", " ");
			request.setAttribute("memo", " ");
		}
		
	}
}
