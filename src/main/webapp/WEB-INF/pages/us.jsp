<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Allusers</title>
</head>
<body>

<h1>
All users
</h1>


<c:forEach items="${users}" var="u">

	<div class="card">
	
	<div class="card-body">
	
	<h3><c:out value="${u.name }"></c:out></h3>
	<p><c:out value="${u.email }"></c:out><br><c:out value="${u.role }"></c:out></p>
	
	</div>
	
	</div>

</c:forEach>

</body>
</html>