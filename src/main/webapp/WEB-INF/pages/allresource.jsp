<%@include file="head.jsp"%>

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


<h2 style="color: white;">All available resources</h2>


<div class="container">
	<div class="main-body">


		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Resource</th>
					<th scope="col">Total</th>
					<th scope="col">Available</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="res" items="${res }">
					<tr>
						<th scope="row">${res.type }</th>
						<td>${res.total }</td>
						<td>${res.available }</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>

</div>


