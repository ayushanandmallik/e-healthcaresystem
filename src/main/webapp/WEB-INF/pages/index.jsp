<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="head.jsp"%>
    

    


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Healthcare System</title>
  </head>
  

  <body>
      <nav class="navbar navbar-dark bg-primary justify-content-between">
  <a class="navbar-brand" href="/healthcaresystem/home" style="margin-left:20px;">E-HealthCare System</a>
  <form class="form-inline">
    <a href="adminlogin"><button type="button" class="btn btn-light" style="margin-right:20px;">Admin login</button></a>
  </form>
</nav>
  <div>
    <div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    

<h1><c:out value="${msg}"></c:out>	</h1>
 
 <style>
 button{
 	width:130px;
 }
 </style>
 
 
    
    <div style="display: flex; margin:150px;">
<div class="card" style="width: 18rem; margin:10px;">
  <div class="card-body">
  <img class="card-img-top" src="https://news.yale.edu/sites/default/files/styles/horizontal_image/public/doctor-patient-relationship.jpg?itok=Wh0XAjma&c=b34d959e670923cd301a7c2d34f9c8c9">
  
  
  <p></p>
    <h5 class="card-title"><b>YOUR ROLE</b></h5>
    <hr />
    <p class="card-text"><i>Select your role from below:</i></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><a href="doctorlogin">
<button type="button" class="btn btn-info">I'm a doctor</button></a></li>
<li class="list-group-item"><a href="patientfront">
<button type="button" class="btn btn-info">I'm a patient</button></a></li>
  </ul>
</div>

</div>

</div>
</div>


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
</html>
