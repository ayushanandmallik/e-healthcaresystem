<%@include file="head.jsp"%>
<%@include file="adminnav.jsp" %>

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
<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    
<h1 style="color: white;">Edit Patient's blood group</h1>


<div>
	<form action="${id }" method="post">


		
		<label for="bloodgroup" class="form-label">Blood Group</label> <select class="form-select"
			aria-label="Default select example" name="bloodgroup">
			<option selected>Blood group</option>
			
			
<c:forEach begin="0" end="7" varStatus="bl">
			<option value="${b.get(bl.current) }">${b.get(bl.current) }</option>
			
			</c:forEach>

		</select>

		<br>
		<button type="submit" class="btn btn-primary">Submit</button>



	</form>
<br>
	<a href="/healthcaresystem/patprofile/${id }"><button class="btn btn-warning">Discard</button></a>
	
</div>
</div>
