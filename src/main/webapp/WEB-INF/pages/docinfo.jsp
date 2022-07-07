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

if (session.getAttribute("users") == null) {
%>
<c:redirect url="/doctorlogin" />
<%
}
%>

 <nav class="navbar navbar-expand-lg navbar-light bg-primary justify-content-between" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="/healthcaresystem/home" style="margin-left:20px;">E-HealthCare System</a>
 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/healthcaresystem/docprofile">Home <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="docinfo/${uid }">Your profile</a>
      </li>	
    </ul>
  <form class="form-inline">
  <a class="btn btn-primary " href="logout" style="margin-right:20px;">Logout</a>
  
 </form>
</nav>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    

<h1>
	<c:out value="${msg }"></c:out>
</h1>


<div class="container">
	<div class="main-body">

<h2 style="color:white;">Your profile</h2>


				<div class="card mt-3">
					<ul class="list-group list-group-flush">
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">Full name</h6> <span class="text-secondary">${user.first_name } ${user.last_name }</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">Email</h6> <span class="text-secondary">${c.email }</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">Contact</h6> <span class="text-secondary">${c.phone_no }</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">Department</h6> <span class="text-secondary">${dept.dept }</span>
						</li>

					</ul>
				</div>

			</div>














		</div>



		
	</div>
</div></div>