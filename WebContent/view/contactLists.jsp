<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>List of Contact</title>
</head>
<body>
<h3>Contacts List Page</h3>
<table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Memo</th>
        </tr>
        <c:forEach var="contacts" items="${requestScope.lists}">
            <tr>
            <td><c:out value="${contacts.name}"></c:out></td>
			<td><c:out value="${contacts.phone}"></c:out></td>
			<td><c:out value="${contacts.email}"></c:out></td>
			<td><c:out value="${contacts.memo}"></c:out></td>
			</tr>
        </c:forEach>
    </table>
    </br>
    <form action="mainServlet" method="get">
		<input type="submit" value="Back" name="button">
	</form>
</body>
</html>