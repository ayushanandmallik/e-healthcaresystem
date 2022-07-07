<%@include file="head.jsp" %>

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
    
<h1 style="color:white;">Update resource</h1>




 


<h1><c:out value="${msg}"></c:out>	</h1>
	<div>
		<form action="updateresource" method="post">
			
			
			
				<select class="form-select" aria-label="Default select example" name="id">
  <option selected>--Select--
  <c:forEach var="res" items="${res }">
  
  <option value="${res.id }">${res.type }</option>
  </c:forEach>
  </select>
			</br>
	<!--orm>
		
		<input type="radio" name="act" id="add" value="add"/>
		<label for="add">Add</label>
		<input type="radio" name="act" id="sub" value="sub"/>
		<label for="sub">Subtract</label>
		
	</form-->
			
			<label for="exampleInputName" class="form-label">New Total</label>
			<input type="text" name="total" class="form-control"
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
