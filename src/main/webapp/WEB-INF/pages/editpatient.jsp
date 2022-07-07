<%@include file="head.jsp" %>

<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if(session.getAttribute("users")==null){
	%>
	<c:redirect url="/doctorlogin" />
	<% 
	}
%>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h1 style="color:white;">Edit Patient's treatment</h1>


	<div>
		<form action="${id }" method="post">
				
				<label for="exampleInputName" class="form-label">Symptoms</label>
			<input type="text" name="symptoms" class="form-control"
				id="exampleInputName" 
				/>
				<br>
				
				<label for="exampleInputName" class="form-label">Disease</label>
			<input type="text" name="disease" class="form-control"
				id="exampleInputName" 
				/><br>
				
				<label for="exampleInputName" class="form-label">Prescriptions</label>
			<input type="text" name="prescription" class="form-control"
				id="exampleInputName" 
				/>
				<br>
		
			
		<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			
			

		</form>
	
	<br>
	<a href="/healthcaresystem/patprofile/${id }"><button class="btn btn-warning">Discard</button></a>
	
	</div>
	</div>
