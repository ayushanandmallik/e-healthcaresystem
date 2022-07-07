<%@include file="head.jsp" %>
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
 <nav class="navbar navbar-expand-lg navbar-light bg-primary justify-content-between" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="/healthcaresystem/home" style="margin-left:20px;">E-HealthCare System</a>
 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="adminprofile">Home <span class="sr-only"></span></a>
      </li>
    </ul>
  <form class="form-inline">
  <a class="btn btn-primary " href="logout" style="margin-right:20px;">Logout</a>
  
 </form>
</nav>
<h1 style="color:white;">Add Resuorce</h1>

<h1><c:out value="${msg}"></c:out>	</h1>
	<div>
		<form action="addresource" method="post">
			
			
			
			
			<label for="exampleInputName" class="form-label">Type</label>
			<input type="text" name="type" class="form-control"
				id="exampleInputName" 
				required="required" />
			
			<label for="exampleInputEmail1" class="form-label">Total</label>
			<input type="text" name="total" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				required="required" />
				
				<label for="exampleInputName" class="form-label">Available</label>
			<input type="text" name="available" class="form-control"
				id="exampleInputName" 
				required="required" />
				
				
				
		
			
		<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			
			

		</form>
		
		<a href="adminprofile">
		<button type="submit" class="btn btn-primary" style="margin:10px;">Go back to your profile</button>
	</a>
	</div>
</div>