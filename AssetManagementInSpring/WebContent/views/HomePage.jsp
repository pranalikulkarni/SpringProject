<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>
.dropbtn {
    background-color: rgb(153,204,255);
    color: black;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
    text-align:center;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 100px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
} 
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {
	background-color: rgb(204,229,255);
	}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: rgb(102,178,255);
}  
</style>
</head>
<body>
<h2 align = "right"><a href="logout.asset">LogOut</a></h2>
<div class="banner">
<h1>Asset Request Form</h1>
</div>
<a href="raiseRequest.asset">Raise Request</a>

<div class="dropdown">
		<button class="dropbtn">View Request</button>
	  	<div class="dropdown-content">
    <c:forEach var="allocId" items ="${allocId}">
     <a href="viewStatus.asset?allocationId=${allocId.allocationId}"><c:out value=" ${allocId.allocationId}"></c:out><br></a>
    </c:forEach>
    </div>
    </div>
<!-- <a href="viewStatus.asset">View Request</a> -->

</body>
</html>