<%@include file="head.jsp"%>
<%@include file="adminnav.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    

<c:if test="${not empty msg}">
	<c:out value="${msg}" />
</c:if>
<h2>${msg }</h2>


<h2 style="color: white;">Doctor's list</h2>


<div class="container">
	<div class="main-body">


		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone no</th>
					<th scope="col">Department</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${d }">
				<c:forEach var="c" items="${c }">
				<c:forEach var="dept" items="${dept }">
				<c:if test="${d.department == dept.id }">
				<c:if test="${d.contact == c.id }">
					<tr>
						<th scope="row">${d.first_name } ${d.last_name }</th>
						<td>${c.email }</td>
						<td>${c.phone_no }</td>
						<td>${dept.dept }</td>
					</tr>
					</c:if>
					</c:if>
					</c:forEach>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>


</div>

