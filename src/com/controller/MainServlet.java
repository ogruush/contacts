package com.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.Contacts;
import com.util.IContactDB;
import com.dao.ContactsDao;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		String button_param = request.getParameter("button");
		
		if(button_param.equals("Back")){
			RequestDispatcher rs = request.getRequestDispatcher("view/main.jsp");
			rs.forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		IContactDB db = new ContactsDao();
		List<Contacts> lists = new ArrayList<Contacts>();
		int userid = Integer.parseInt(request.getParameter("id"));
		
		lists = db.getAllContacts(userid);
		
		String button_param = request.getParameter("button");
		if(button_param.equals("Contact Lists")){
			if(lists != null){
				request.setAttribute("lists", lists);
			}else{
				out.println("No contacts.");
			}
			RequestDispatcher rs = request.getRequestDispatcher("view/contactLists.jsp");
			rs.forward(request, response);
		}else if(button_param.equals("Add Contact")){
			RequestDispatcher rs = request.getRequestDispatcher("view/addContact.jsp");
			rs.forward(request, response);
		}else if(button_param.equals("Search Contact")){
			RequestDispatcher rs = request.getRequestDispatcher("view/searchContact.jsp");
			rs.forward(request, response);
		}else {
			out.println("You signed out.");
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.include(request, response);
		}
		
		
	}
	
}
