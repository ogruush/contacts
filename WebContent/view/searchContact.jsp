<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact Page</title>
</head>
<body>
<h3>Search Contact Page</h3>
	<form action="searchContactServlet" method="post">
		<input type="hidden" value=<%= session.getAttribute("userid") %> name="id">
		
		<p>Search Name: <input type="text" name='searchName' >
		<input type="hidden" value=<%= session.getAttribute("searchName") %> name="sname">
		<input type="submit" value="Search" name="button"></p>
		
		<p>Name: <input type="text" value=<%= session.getAttribute("rname") %> name='name'  ></p>
		<p>Phone: <input type="text" value=<%= session.getAttribute("rphone") %> name='phone' ></p>
		<p>Email: <input type="text" value=<%= session.getAttribute("remail") %> name='email' ></p>
		<p>Memo: <input type="text" value=<%= session.getAttribute("rmemo") %> name='memo' maxlength='50'></p>
		<input type="submit" value="Edit" name="button">
		<input type="submit"value="Delete" name="button">
		<input type="submit"value="Back" name="button">
	</form>
</body>
</html>