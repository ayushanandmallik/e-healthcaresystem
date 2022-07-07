<%@include file="head.jsp"%>

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


<h2 style="color: white;">${p.first_name }'s treatment history</h2>


<div class="container">
	<div class="main-body">


		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
					<th scope="col">Symptoms</th>
					<th scope="col">Disease</th>
					<th scope="col">Prescription</th>
					<th scope="col">Doctor</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${t }">
							<c:forEach var="d" items="${d }">
							<c:if test="${t.doctor == d.id }">
							<tr>
								<td>${t.time.toLocalDate() }</td>
								<td>${t.time.toLocalTime() }</td>
								<td>${t.symptoms }</td>
								<td>
								${t.disease }
								</td>
								<td>${t.prescription }</td>
								<td>${d.first_name } ${d.last_name }</td>
								

							</tr>
				</c:if>
				</c:forEach>
				</c:forEach>
				
			</tbody>
		</table>

	</div>
</div>
</div>



