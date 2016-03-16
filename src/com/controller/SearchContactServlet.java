package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Contacts;
import com.util.IContactDB;
import com.dao.ContactsDao;

public class SearchContactServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();

		int userid = Integer.parseInt(request.getParameter("id"));
		String searchName = request.getParameter("searchName");
		
		session.setAttribute("searchName", searchName);
		
		Contacts check = new Contacts(userid, searchName, "", "", "");
		
		IContactDB db = new ContactsDao();
		Contacts contact = db.searchContacts(check);
		
		String button_param = request.getParameter("button");
		if(button_param.equals("Search")){
			
			if(contact != null){
				String name = contact.getName();
			    session.setAttribute("rname", name);
			    String  phone = contact.getPhone();
			    session.setAttribute("rphone", phone);
			    String email = contact.getEmail();
			    session.setAttribute("remail", email);
			    String memo = contact.getMemo();
			    session.setAttribute("rmemo", memo);
		
				RequestDispatcher rs = request.getRequestDispatcher("view/searchContact.jsp");
				rs.include(request, response);

			}else{
				out.println("There is no contact informarion.");
				RequestDispatcher rs = request.getRequestDispatcher("view/searchContact.jsp");
				rs.include(request, response);
			}
	
		}else if(button_param.equals("Edit")){
			
			String sname = request.getParameter("sname");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String memo = request.getParameter("memo");
					
			Contacts editContact = new Contacts(userid, name, phone, email, memo);
			out.println(editContact.getUserid()+editContact.getName()+editContact.getPhone()+editContact.getEmail()+editContact.getMemo());
			
			if(db.updateContact(editContact, sname)){
				out.println("Contact information updated.");
				
			}else{
				out.println("Contact information cannot updated.");
			}
			
			RequestDispatcher rs = request.getRequestDispatcher("view/searchContact.jsp");
			rs.include(request, response);

			
		}else if(button_param.equals("Delete")){
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String memo = request.getParameter("memo");
					
			Contacts deleteContact = new Contacts(userid, name, phone, email, memo);
			
			if(db.deleteContact(deleteContact)){
				out.println("Contact information deleted.");
			}else{
				out.println("Contact information not deleted.");
			}
				
			RequestDispatcher rs = request.getRequestDispatcher("view/searchContact.jsp");
			rs.include(request, response);

		}else{
			RequestDispatcher rs = request.getRequestDispatcher("view/main.jsp");
			rs.forward(request, response);
		}
		
	}
	
}
