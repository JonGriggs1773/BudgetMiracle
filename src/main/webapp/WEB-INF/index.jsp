<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<title>Login and Register</title>
</head>
<body>
	<div class="container">
		<div class = "row justify-content-md">
			<div class = "col-lg-6">
				<h1 class = "text-success">BudgetMiracle</h1>
			</div>
		</div>
		
		<div class = "row">
		
			<div class = "col-lg-3">
			
				<p class="h3">Register Here</p>	
	
				<form:form action = "/register" method = "post" modelAttribute = "user">
				
				  <div class="mb-3">
				    <form:label class="form-label" path = "firstName">First Name</form:label>
				    <form:errors class = "text-danger" path = "firstName"/>
				    <form:input type="text" class="form-control"  path = "firstName"/>
				  </div>
				  
				  <div class="mb-3">
				    <form:label class="form-label" path = "lastName">Last Name</form:label>
				    <form:errors class = "text-danger" path = "lastName"/>
				    <form:input type="text" class="form-control"  path = "lastName"/>
				  </div>
				  
				  <div class="mb-3">
				    <form:label class="form-label" path = "email">Email address</form:label>
				    <form:errors class = "text-danger" path = "email"/>
				    <form:input type="email" class="form-control" path = "email"/>
				    <div class="form-text">We'll never share your email with anyone else.</div>
				  </div>
				  
				  <div class="mb-3">
				    <form:label for="exampleInputPassword1" class="form-label" path = "password">Password</form:label>
				    <form:errors class = "text-danger" path = "password"/>
				    <form:input type="password" class="form-control" path = "password"/>
				  </div>
				  
				  <div class="mb-3">
				    <form:label for="exampleInputPassword1" class="form-label" path = "confirmPassword">Confirm Password</form:label>
				    <form:errors class = "text-danger" path = "confirmPassword"/>
				    <form:input type="password" class="form-control" path = "confirmPassword"/>
				  </div>
				  
				  <input type = "submit" class = "btn btn-info" value = "Register"/>
				  
				</form:form>
		
			</div>
			
			
			<div class = "col-lg-3">
			
				<p class="h3">Login Here</p>	
	
				<form:form action = "/login" method = "post" modelAttribute = "loginUser">
				  
				  <div class="mb-3">
				    <form:label class="form-label" path = "email">Email address</form:label>
				    <form:errors class = "text-danger" path = "email"/>
				    <form:input type="email" class="form-control" path = "email"/>
				    <div class="form-text">We'll never share your email with anyone else.</div>
				  </div>
				  
				  <div class="mb-3">
				    <form:label for="exampleInputPassword1" class="form-label" path = "password">Password</form:label>
				    <form:errors class = "text-danger" path = "password"/>
				    <form:input type="password" class="form-control" id="exampleInputPassword1" path = "password"/>
				  </div>
				  

				  
				  <input type = "submit" class = "btn btn-info" value = "Login"/>
				  
				</form:form>
		
			</div>
		</div>
		<div class = "custom-col">
			<div class = "col-lg-5">
				<div class="card">
				  <img src = "images/counting-money-in-the-dark.jpg" class="card-img-top" alt="card-img-top">
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Budget Miracle is a tool that anyone can use to try and visualize their financial situation. 
				    Say goodbye to, stubborn to make, spreadsheets, and say hello to the ability to find where you may be spending too much money. 
				    Or maybe even find an expense that is no longer necessary. Save money more efficiently and don't forget to check out our
				    tips and tricks page once you sign up.</p>
				  </div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>