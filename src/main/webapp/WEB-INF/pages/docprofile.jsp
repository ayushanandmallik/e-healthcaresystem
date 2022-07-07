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
        <a class="nav-link" href="docprofile">Home <span class="sr-only"></span></a>
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
	<div class="main-body" style="margin:20px;">


<h3 style="color:white;">Your Patient's list</h3>

			<div class="col-md-8">
				<div class="card mb-3">
				
					<div class="card-body">
						<c:forEach var="p" items="${p }">
						<c:forEach var="pd" items="${pd }">
						<c:forEach var="cl" items="${cl }">
						<c:if test="${p.pid == pd.pid }">
						<c:if test="${cl.id==p.contact }">
						<c:if test="${pd.status==1 }">
							<div class="row">

								<div class="col-sm-3">
									<a href="patprofile/${p.pid }">
										<h6 class="mb-0">${p.first_name } ${p.last_name }</h6>
									</a>
								</div>
						
							</div>

							<hr>
							</c:if>
							</c:if>
							</c:if> 
							</c:forEach>
							</c:forEach>
						</c:forEach>


					</div>

				</div>

			</div>












		</div>



		
	</div>
</div></div>