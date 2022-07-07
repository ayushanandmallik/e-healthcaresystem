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
<h1 style="color:white;">Remove Doctor</h1>


<h1>
<c:out value="${msg }"></c:out></h1>
<form action="removedoctor" method="post">

			<label for="exampleInputName" class="form-label">Select doctor to remove</label>
				<select class="form-select" aria-label="Default select example" name="email" style="Width:150px;">
  <option selected>Select a doctor</option>
  <c:forEach var="d" items="${doctors }">
  <option value="${d.email }">${d.name }</option>
  </c:forEach>
  </select>
 
  <button type="submit" class="btn btn-primary" style="margin: 10px;">Submit</button>
		</form>