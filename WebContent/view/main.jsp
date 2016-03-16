<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
	<form action="mainServlet" method="post">
	<input type="hidden" value=<%= session.getAttribute("userid") %> name="id">
	<input type="submit" value="Contact Lists" name="button">
	<input type="submit" value="Add Contact" name="button">
	<input type="submit" value="Search Contact" name="button">
	<input type="submit" value="Sign Out" name="button">
	</form>
</body>
</html>