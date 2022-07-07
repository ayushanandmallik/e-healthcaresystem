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
    
<h1 style="color: white;">Add Doctor</h1>




<c:if test="${msg }">

	<h1>${msg }</h1>

</c:if>
<h1>
	<c:out value="${msg}"></c:out>
</h1>
<div>
	<form action="adddoctor" method="post">




		<label for="exampleInputName" class="form-label">First Name</label> <input
			type="text" name="first_name" class="form-control"
			id="exampleInputName" required="required"
			/> <br><label for="exampleInputName"
			class="form-label">Last Name</label> <input type="text"
			name="last_name" class="form-control" id="exampleInputName"
			required="required" /> <br><label for="exampleInputEmail1"
			class="form-label">Email</label> <input type="email" name="email"
			class="form-control" id="exampleInputEmail1"
			aria-describedby="emailHelp" required="required"
			pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
			title="Please enter email address like 'abc123@gmail.com'" /><br> <label
			for="exampleInputName" class="form-label">Phone no</label> <input
			type="text" name="phone" class="form-control" id="exampleInputName"
			required="required"
			pattern="^(\+\d{1,2}\s?)?1?\-?\.?\s?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" title="Phone number must be 10 digits" /> <br><label
			for="exampleInputName" class="form-label">Department</label> <select
			class="form-select" aria-label="Default select example"
			name="department" required="required">
			<option selected>Department</option>
			<c:forEach var="d" items="${department }">

				<option value="${d.id }">${d.dept }</option>
			</c:forEach>
		</select> <br>

		<button type="submit" class="btn btn-primary">Submit</button>



	</form>

	<a href="adminprofile">
		<button type="submit" class="btn btn-primary" style="margin: 10px;">Go
			back to your profile</button>
	</a>
</div>
</div>
