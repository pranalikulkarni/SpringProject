<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
a:hover {
    font-size: 1.1em;
}
</style>
</head>
<body>

<c:if test="${sessionScope.loginDetails != null}">

<a href="logout.asset">LogOut</a>

<br/>
Welcome
 
</c:if>

	<c:if test="${sessionScope.loginDetails == null}">
		
		<c:out value="${sessionScope.valid}"></c:out>
	
		Session is Logged Out
	
	</c:if>	


</body>
</html>