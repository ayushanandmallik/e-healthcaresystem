<%@include file="head.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    

<div>



	<h1>Register Admin</h1>

	<h1 style="color: red;">${msg }</h1>
	<br>
	<form:form action="registeradmin" method="post" modelAttribute="users">
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
			required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
			title="Please enter email address like 'abc123@gmail.com'" />
		<form:errors path="email" />
		<br>
</div>
<div class="mb-3">
	<label for="exampleInputPassword1" class="form-label">Password</label>
	<form:input path="password" type="password" class="form-control"
		id="pwd" required="required"
		pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
		title="Must contain at least one number and one uppercase letter, one lowercase letter, one special character and at least 8 or more characters" />

	<input type="checkbox" onclick="myFunction()">Show Password
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>



