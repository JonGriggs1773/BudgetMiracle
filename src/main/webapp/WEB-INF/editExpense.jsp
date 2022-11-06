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
<title>Edit Expense</title>
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
					Edit Expense
				</div>
				<div class="card-body">
					<h5 class="card-title">Edit Your Expense Below!!!</h5>
				</div>
				<div class = "row justify-content-md-center">
					<div class = "row h-100 justify-content-center align-items-center">
						<div class="form-floating mb-3">
							<form:form action = "/expense/${oneExpense.id}/edit" method = "post" modelAttribute = "expense">
								<input type = "hidden" name = "_method" value = "put"/>
								
								<form:input path = "user" type = "hidden" value = "${oneUser.id}"/>
								
			  					<form:label for="floatingInput" path = "name" class = "text-black-50">Name</form:label>
								<form:input type="text" path = "name" class="form-control" id="floatingInput" value = "${oneExpense.name}"/>
						
			  					<form:label for="floatingInput" path = "amount" class = "text-black-50">Amount</form:label>
			  					<form:input type="number" path = "amount" class="form-control" id="floatingInput" value = "${oneExpense.amount}"/>
			  				
								<div class = "pt-4">
			  						<input type = "submit" value = "Confirm" class = "btn btn-warning"/>
								</div>		  				
		  				
		  					</form:form>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					"Never spend money before you have earned it." - Thomas Jefferson
				</div>
			</div>
		</div>
	</div>
</body>
</html>