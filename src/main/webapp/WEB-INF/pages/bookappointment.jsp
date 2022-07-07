<%@include file="head.jsp" %>
 <nav class="navbar navbar-dark bg-primary justify-content-between">
  <a class="navbar-brand" href="/healthcaresystem/home" style="margin-left:20px;">E-HealthCare System</a>

</nav>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h1 style="color:white;">Book Appointment</h1>



<h1><c:out value="${msg}"></c:out>	</h1>
	<div>
		<form action="bookappointment" method="post">
			
			
			
			
			<label for="exampleInputName" class="form-label">First Name</label>
			<input type="text" name="first_name" class="form-control"
				id="exampleInputName" 
				required="required" /><br>
				<label for="exampleInputName" class="form-label">Last Name</label>
			<input type="text" name="last_name" class="form-control"
				id="exampleInputName" 
				required="required" />
			<br>
			<label for="exampleInputEmail1" class="form-label">Email</label>
			<input type="email" name="email" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
			title="Please enter email address like 'abc123@gmail.com'"/>
				<br>
				<label for="exampleInputName" class="form-label">Phone no</label>
			<input type="text" name="phone" class="form-control"
				id="exampleInputName" 
				required="required" />
				
				
				<br>
				<label for="exampleInputName" class="form-label">Doctor</label>
				<select class="form-select" aria-label="Default select example" name="doctor" required="required">
  <option selected>Doctor</option>
  <c:forEach var="d" items="${d }">
  <c:forEach var="dept" items="${dept }">
  <c:if test="${d.department== dept.id}">
  <option value="${d.id }">${d.first_name } ${d.last_name } (${dept.dept })</option>
 </c:if>
  </c:forEach>
  </c:forEach>
  </select>
		
				
		
			
		<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	<br>
	<a href="/healthcaresystem/patientfront"><button class="btn btn-warning">Discard</button></a>
	
	</div></div>
