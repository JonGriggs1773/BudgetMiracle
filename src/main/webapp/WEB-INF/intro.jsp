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
<title>Getting to know you</title>
</head>
<body>
	<div class = "container-custom">
			<div class = "row justify-content-md-center">
				<nav class="navbar navbar-expand-xl navbar-light bg-light">
				  <div class="container-fluid">
				    <h1 class="text-success">BudgetMiracle</h1>
				  </div>
				</nav>
			</div>
			<div class = "row h-100 justify-content-center align-items-center">
				<div class="card">
				  <div class="card-header">
				    Monthly Income
				  </div>
				  <div class="card-body">
				    <h5 class="card-title">How we are going to help you!!!</h5>
				    <p class="card-text">To help you save money and find your financial breathing room, first we need to determine your
				    monthly income. Click the button that best describes you.</p>
				    <a href="/input/income" class="btn btn-info">I know how to do this</a>
				    <a href="/pay/frequency" class="btn btn-warning">I don't know how to do this</a>
				  </div>
				  <div class="card-footer text-muted">
				    I wish you luck on your financial journey
				  </div>
				</div>
			</div>
		
	</div>
</body>
</html>