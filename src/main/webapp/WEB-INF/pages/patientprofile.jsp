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
	<c:redirect url="/patientlogin" />
	<% 
	}
%>
 <nav class="navbar navbar-dark bg-primary justify-content-between">
  <a class="navbar-brand" href="/healthcaresystem/home" style="margin-left:20px;">E-HealthCare System</a>
  <form class="form-inline">
 <a class="btn btn-primary " href="logout" style="margin-right:20px;">Logout</a>
   </form>
</nav>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h2>Your profile</h2>


<h2>${msg }</h2>



<div class="container">
	<div class="main-body">



		<div class="row gutters-sm">
			<div class="col-md-4 mb-3">
				<div class="card">
					<div class="card-body">
						<div class="d-flex flex-column align-items-center text-center">
							<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
								alt="Admin" class="rounded-circle" width="150">
							<div class="mt-3">
								<h4>${p.first_name } ${p.last_name }</h4>
								<p class="text-secondary mb-1"></p>
								
								<p class="text-muted font-size-sm">Status- <c:if test="${pd.status==1 }">Active</c:if> <c:if test="${pd.status==0 }">Discharged/Treated</c:if> </p>

							</div>
						</div>
					</div>
				</div>
				<div class="card mt-3">
					<ul class="list-group list-group-flush">
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">
							Full name
							</h6> <span class="text-secondary">${p.first_name} ${p.last_name }</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">
								Email
							</h6> <span class="text-secondary">${c.email }</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">
								Contact
							</h6> <span class="text-secondary">${c.phone_no }</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
							<h6 class="mb-0">
								Blood group
							</h6> <span class="text-secondary">${pd.bloodgroup }</span>
						</li>
						
					</ul>
				</div>
			</div>
				
				<div class="col-md-8">
				<div class="card mb-3">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Symptoms</h6>
							</div>
							<div class="col-sm-9 text-secondary">${t.symptoms }</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Disease</h6>
							</div>
							<div class="col-sm-9 text-secondary">${t.disease }</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Doctor Assigned</h6>
							</div>
							<div class="col-sm-9 text-secondary">${d }</div>
						</div>
					
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Ward</h6>
							</div>
							<div class="col-sm-9 text-secondary">${w.ward }</div>
						</div>
						
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Prescription</h6>
							</div>
							<div class="col-sm-9 text-secondary">${t.prescription }</div>
						</div>
						
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Bed no</h6>
							</div>
							<div class="col-sm-9 text-secondary">${bed }</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Reports</h6>
							</div>
							
							<c:forEach var="r" items="${r }">
							<a href="downloadreport/${p.pid }/${r.id}" target="_blank">
								<div class="col-sm-9 text-secondary">${r.filename }</div></a>
								
							</c:forEach>
						
						</div>
						<hr>
						<a class="btn btn-primary "
								href="/healthcaresystem/patprofile/treatmenthistory/${p.pid }">See your treatment history</a>
					</div>
				</div>
				
			</div>
		</div>

	</div>
</div>
</div>