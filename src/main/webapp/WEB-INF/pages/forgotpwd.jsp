
<%@include file="head.jsp"%>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h1 style="color: white;">Reset password</h1>

<h1>
	<c:out value="${msg}"></c:out>
</h1>

<div>

	<form action="forgotpwd" method="post">

		<label for="exampleInputEmail1" class="form-label">Email</label> <input
			type="email" name="email" class="form-control"
			id="exampleInputEmail1" aria-describedby="emailHelp"
			required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
			title="Please enter email address like 'abc123@gmail.com'" /> <br>
		<label for="exampleInputEmail1" class="form-label">New
			Password</label> <input type="password" name="npwd" class="form-control"
			id="npwd" required="required"
			pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
			title="Must contain at least one number and one uppercase letter, one lowercase letter, one special character and at least 8 or more characters" /><input
			type="checkbox" onclick="myFunction1()">Show Password <br>
		<br>
		<button type="submit" class="btn btn-primary">Submit</button>


	</form>

	<br>
	<a href="/healthcaresystem">
	<button type="submit" class="btn btn-warning">Discard</button></a>
	


</div>
</div>