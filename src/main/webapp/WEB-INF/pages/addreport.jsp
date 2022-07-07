<%@include file="head.jsp"%>
<%@include file="adminnav.jsp" %>
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
    
<h1 style="color: white;">Add Report</h1>

<c:if test="${msg }">

	<h1>${msg }</h1>

</c:if>
<h1>
	<c:out value="${msg}"></c:out>
</h1>
<div>
	<form action="addreport" method="post" enctype="multipart/form-data">




		<label for="exampleInputName" class="form-label">Patient</label> 
		<select class="form-select" aria-label="Default select example" name="patient_id">
  <option selected>---Select---</option>
  <c:forEach var="p" items="${patients }">
  
  <option value="${p.pid }">${p.first_name } ${p.last_name }</option>
  </c:forEach>
  </select>

		<div class="mb-3">
			<label for="formFile" class="form-label">Report</label> <input
				class="form-control" type="file" id="formFile" name="report">
		</div>




		<br>
		<button type="submit" class="btn btn-primary">Submit</button>



	</form>

	<a href="adminprofile">
		<button type="submit" class="btn btn-primary" style="margin: 10px;">Go
			back to your profile</button>
	</a>
</div>
</div>