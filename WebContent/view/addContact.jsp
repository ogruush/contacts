<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact Page</title>
</head>
<body>
<h3>Add contact page</h3>
	<form action="addContactServlet" method="post">
		<input type="hidden" value=<%= session.getAttribute("userid") %> name="id">
		<p>Name: <input type="text" name='name' ></p>
		<p>Phone: <input type="text" name='phone' ></p>
		<p>Email: <input type="text" name='email' ></p>
		<p>Memo: <input type="text" name='memo' ></p>
		<input type="submit" value="Add" name="button">
		<input type="submit" value="Cancel" name="button">
		<input type="submit" value="Back" name="button">
	</form>
</body>
</html>