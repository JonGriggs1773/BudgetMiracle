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
<title>Edit Your Income</title>
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
					Edit Income
				</div>
				<div class="card-body">
					<h5 class="card-title">New Job?</h5>
				</div>
				<div class = "row justify-content-md-center">
					<div class = "row h-100 justify-content-center align-items-center">
						<div class="form-floating mb-3">
							<form:form action = "/income/${userIncome.id}/edit" method = "post" modelAttribute = "income">
								<input type = "hidden" name = "_method" value = "put"/>
									
								<form:input path = "user" type = "hidden" value = "${oneUser.id}"/>
									
				  				<form:label for="floatingInput" path = "source" class = "text-black-50">Name</form:label>
								<form:input type="text" path = "source" class="form-control" id="floatingInput" value = "${userIncome.source}"/>
							
				  				<form:label for="floatingInput" path = "income" class = "text-black-50">Monthly Income</form:label>
								<form:input type="number" path = "income" class="form-control" id="floatingInput" value = "${userIncome.income}"/>
				  				
								<div class = "pt-4">
				  					<input type = "submit" value = "Confirm" class = "btn btn-info"/>
								</div>		  				
			  			
			  				</form:form>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					"The money you make is a symbol of the value you create" - Idowu Koyenikan
				</div>
			</div>
		</div>
	</div>
</body>
</html>