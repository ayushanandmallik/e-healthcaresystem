<%@include file="head.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>



<div>

	<style>
.error {
	color: red;
}
</style>
<h1>Register Patient</h1>

	<h1 style="color:red;">${msg }</h1>
	<br>
	<form:form action="registerpatient" method="post" modelAttribute="users">
		<div class="mb-3">

			<label for="fname" class="form-label">First Name</label>

			<form:input path="fname" type="text" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				required="required" />
		</div>
		<div class="mb-3">

			<label for="lname" class="form-label">Last Name</label>

			<form:input path="lname" type="text" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				required="required" />
		</div>
		<label for="exampleInputEmail1" class="form-label">Email
			address</label>
		<form:input path="email" type="email" class="form-control"
			id="exampleInputEmail1" aria-describedby="emailHelp"
			required="required" />
</div>
<div class="mb-3">
	<label for="exampleInputPassword1" class="form-label">Password</label>
	<form:input path="password" type="password" class="form-control"
		id="pwd" required="required"/>

<input type="checkbox" onclick="myFunction()">Show Password 
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form:form>


<!--  


<c:if test="${page=='save' }">

	
	<h1>${msg}</h1>
	
	<a href="adminlogin">
    Login</a>
    <br>
</c:if>


</div>

-->


