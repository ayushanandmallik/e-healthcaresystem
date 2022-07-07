<%@include file="head.jsp"%>
<%@include file="adminnav.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if(session.getAttribute("users")==null){
	%>
	<c:redirect url="/adminlogin" />
	<% 
	}
%>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    

<c:if test="${not empty msg}">
	<c:out value="${msg}" />
</c:if>
<h2>${msg }</h2>


<h2 style="color: white;">Patient's list</h2>


<div class="container">
	<div class="main-body">


		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone no</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${p }">
				<c:forEach var="pl" items="${pl }">
				<c:forEach var="c" items="${c }">
				<c:if test="${p.pid == pl.pid }">
				
				<c:if test="${p.contact == c.id}">
							<tr>
							
								<td><a href="patprofile/${p.pid }" style="color:black;">${p.first_name } ${p.last_name }</a></td>
								<td>${c.email }</td>
								<td>${c.phone_no }</td>
								<td>
								<c:if test="${pl.status == 0}">Discharged</c:if>
								<c:if test="${pl.status==1 }">Active</c:if>
								</td>
								

							</tr>
						</c:if>
				</c:if>
				</c:forEach>
				</c:forEach>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
<a href="adminprofile">
		<button type="submit" class="btn btn-primary" style="margin:10px;">Go back to your profile</button>
	</a>
</div>
</div>



