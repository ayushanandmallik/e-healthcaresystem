
<%@include file="head.jsp" %>
  <nav class="navbar navbar-dark bg-primary justify-content-between">
  <a class="navbar-brand" href="/healthcaresystem/home" style="margin-left:20px;">E-HealthCare System</a>
  <form class="form-inline">
    <a href="adminlogin"><button type="button" class="btn btn-light" style="margin-right:20px;">Admin login</button></a>
  </form>
</nav>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h1 style="color:white;">Patient Login</h1>

<h1><c:out value="${msg}"></c:out>	</h1>

	<div>
		
		<form action="patientlogin" method="post">
		
			<label for="exampleInputEmail1" class="form-label">Email</label>
			<input type="email" name="email" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				required="required" /><br>
			<label for="exampleInputEmail1" class="form-label">Password</label>
			<input type="password" name="password" class="form-control"
		id="pwd" required="required"/><input type="checkbox" onclick="myFunction()">Show Password 
		<br><a href="forgotpwd" style="color:black;">Forgot password</a>
		<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			
			
		</form>
		<br>
	<a href="/healthcaresystem/patientfront"><button class="btn btn-warning">Discard</button></a>
	
		<br>
		
		
	
		
	
	
	</div>
	</div>