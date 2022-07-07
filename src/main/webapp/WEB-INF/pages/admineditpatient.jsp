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
    
<h1 style="color: white;">Edit Patient's ward and Bed</h1>


<div>
	<form action="${id }" method="post">


		
		<label for="ward" class="form-label">Ward</label> <select class="form-select"
			aria-label="Default select example" name="ward" required="required">
			<option selected>Ward</option>
			<c:forEach var="w" items="${w }">

				<option value="${w.id }">${w.ward }</option>
			</c:forEach>
		</select><br>
		 <label
			for="bed" class="form-label">Bed</label> <input
			type="text" name="bed" class="form-control" id="exampleInputName" required="required"/>



		<br>
		<button type="submit" class="btn btn-primary">Submit</button>



	</form>
	<br>
	<a href="/healthcaresystem/patprofile/${id }"><button class="btn btn-warning">Discard</button></a>
	

</div></div>
