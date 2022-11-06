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
<title>Oops!</title>
</head>
<body>
	<div class = "container-custom">
		<div class = "row justify-content-md-center">
			<nav class="navbar navbar-expand-xl navbar-light bg-light">
			  <div class="container-fluid">
			     <h1 class="text-success">BudgetMiracle</h1>
			  </div>
			  <div class = "container-fluid">
			  	<a href = "/logout" class = "text-success">Logout</a> 
			  	<a href = "/dashboard" class = "text-success">Home</a> 
			  </div>
			</nav>
		</div> 
		<div class = "row h-100 justify-content-center align-items-center">
			<div class="card">
				<div class="card-header">
					Oops!
				</div>
				<div class="card-body">
					<h5 class="card-title">
						Sorry, <c:out value = "${oneUser.firstName}"/>, it seems you have
						already entered your income.
					</h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>