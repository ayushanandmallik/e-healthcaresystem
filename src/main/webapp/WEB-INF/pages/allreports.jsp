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
    
<h1>
	<c:out value="${msg }"></c:out>
</h1>


<div class="container">
	<div class="main-body">


		<table class="table table-striped">
			<thead>
				<tr>

					<th scope="col">Patient</th>
					<th scope="col">Reports</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${reports}" var="r">
				<c:forEach items="${patient}" var="p">
						<c:if test="${p.pid == r.patient_id }">
							<tr>
								<td>${p.first_name } ${p.last_name }</td>
							
								<td><a href="downloadreport/${p.pid }/${r.id}" target="_blank" style="color:black;">${r.filename }</a></td>
								

							</tr>
						</c:if>

					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
<a href="adminprofile">
		<button type="submit" class="btn btn-primary" style="margin:10px;">Go back to your profile</button>
	</a>	
	</div>
</div>

</div>
