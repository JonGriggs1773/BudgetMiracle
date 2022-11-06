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
<title>Add Your Bill</title>
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
					Add Bill
				</div>
				<div class="card-body">
					<h5 class="card-title">Input Your Bill Below!!!</h5>
				</div>
				<div class = "row justify-content-md-center">
					<div class = "row h-100 justify-content-center align-items-center">
						<div class="form-floating mb-3">
							<form:form action = "/confirm/new/bill" method = "post" modelAttribute = "bill">
							
								<form:input path = "user" type = "hidden" value = "${oneUser.id}"/>
								
			  					<form:label for="floatingInput" path = "name" class = "text-black-50">Name</form:label>
								<form:input type="text" path = "name" class="form-control" id="floatingInput"/>
						
			  					<form:label for="floatingInput" path = "amount" class = "text-black-50">Amount</form:label>
			  					<form:input type="number" path = "amount" class="form-control" id="floatingInput"/>
			  				
								<div class = "pt-4">
			  						<input type = "submit" value = "Confirm New Bill" class = "btn btn-danger"/>
								</div>		  				
		  				
		  					</form:form>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					Bills are important, but can be exhausting. Let us help.
				</div>
			</div>
		</div>
	</div>
</body>
</html>