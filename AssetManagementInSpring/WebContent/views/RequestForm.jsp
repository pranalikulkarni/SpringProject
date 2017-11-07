<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="AssetStyle.css" rel="stylesheet">
</head>
<body>
<div class="banner">
<h1>Asset Request Form</h1>
</div>
<br>
<br>
<form:form action="insertRequest.asset" modelAttribute="allocation">
<table>
<tr>
<td>Asset Id:</td>
<td><form:select path="assetId">
<form:option value="">--Select--</form:option>
			<c:forEach  items="${assetIds}" var="assetIds" >
				<form:option value="${assetIds}">${assetIds}</form:option>
			</c:forEach>
</form:select>
</td>
</tr>

<tr>
<td>Employee Id:</td>
<td><form:select path="empNo">
<form:option value="">--Select--</form:option>
			<c:forEach  items="${empIds}" var="empIds" >
				<form:option value="${empIds}">${empIds}</form:option>
			</c:forEach>
</form:select>
</td>
</tr>

<tr>
<td>Quantity:</td>
<td><form:input path="requestedQuantity"/><form:errors path="requestedQuantity"/></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</form:form>

${successMessage} ${requestId}
${errorMessage}

</body>
</html>