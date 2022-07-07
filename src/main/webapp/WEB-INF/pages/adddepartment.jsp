
<%@include file="head.jsp"%>
<%@include file="adminnav.jsp" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("pragma", "no-cache");
response.setDateHeader("Expires", 0);

if (session.getAttribute("users") == null) {
%>
<c:redirect url="/adminlogin" />
<%
}
%>


<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h1 style="color: white;">Add new Department</h1>

<h1>
	<c:out value="${msg}"></c:out>
</h1>
<div>
	<form action="adddepartment" method="post">




		<label for="dept" class="form-label">Department</label> <input
			type="text" name="dept" class="form-control"
			id="exampleInputName" required="required" /> 
		
				<br>
		<button type="submit" class="btn btn-primary">Submit</button>



	</form>

	<a href="adminprofile">
		<button type="submit" class="btn btn-primary" style="margin: 10px;">Go
			back to your profile</button>
	</a>
</div>
</div>

