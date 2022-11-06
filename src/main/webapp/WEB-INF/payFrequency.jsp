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
<title>Pay Frequency</title>
</head>
<body>
	<div class = "container-lg">
		<div class = "row justify-content-md-center">
			<nav class="navbar navbar-expand-xl navbar-light bg-light">
			  <div class="container-fluid">
			     <h1 class="text-success">BudgetMiracle</h1>
			  </div>
			</nav>
		</div> 

		<div class = "row">
			<div class = "col-md-4" id = "cust-col">
				<div class = "text-info">
					<div class = "pt-5">
					<p class = "h4">Weekly</p>
					</div>
				</div>
				<div class = "pt-3">
					<p class = "h5">
						Take an
						average
						paycheck
						amount, with all
						taxes and
						benefits
						removed, and multiply it by 4
					</p>
					<div class = "row h-100 justify-content-center align-items-center">
						<div class="form-floating mb-3">
							<form:form action = "/weekly" method = "post" modelAttribute = "income">
							
							<form:input path = "user" type = "hidden" value = "${oneUser.id}"/>
					
							<form:label for="floatingInput" path = "income" class = "text-black-50">Occupation</form:label>
							<form:input type="text" path = "source" class="form-control"/>
		  					<form:errors path = "source" class = "text-danger"/>
					
		  					<form:label for="floatingInput" path = "income" class = "text-black-50">Weekly Pay</form:label>
		  					<form:input type="number" path = "income" class="form-control" id="floatingInput"/>
		  					<form:errors path = "income" class = "text-danger"/>
		  					
		  					<div class = "pt-3">
		  						<input type = "submit" value = "Confirm Weekly Income" class = "btn btn-warning"/>
		  					</div>
		  					
		  					</form:form>
						</div>
				
					</div>
				</div>
				<img src = "/images/gold-bars-on-an-american-flag.jpg" class="card-img-top" alt="card-img-top">			
			</div>
			<div class = "col-md-4" id = "cust-col">
				<div class = "text-info">
					<div class = "pt-5">
					<p class = "h4">Bi-Weekly</p>
					</div>
				</div>
				<div class = "pt-3">
					<p class = "h5">
						Take an
						average
						paycheck
						amount, with all
						taxes and
						benefits
						removed, and multiply it by 2.
					</p>
					<div class = "row h-100 justify-content-center align-items-center">
						<div class="form-floating mb-3">
							<form:form action = "/bi/weekly" method = "post" modelAttribute = "income">
							
							<form:input path = "user" type = "hidden" value = "${oneUser.id}"/>
							
							<form:label for="floatingInput" path = "income" class = "text-black-50">Occupation</form:label>
							<form:input type="text" path = "source" class="form-control"/>
		  					<form:errors path = "source" class = "text-danger"/>
							
		  					<form:label for="floatingInput" path = "income" class = "text-black-50">Bi-Weekly Pay</form:label>
		  					<form:input type="number" path = "income" class="form-control" id="floatingInput"/>
		  					<form:errors path = "income" class = "text-danger"/>
		  				
		  					<div class = "pt-3">
		  						<input type = "submit" value = "Confirm Bi-Weekly Income" class = "btn btn-warning"/>
		  					</div>
		  				
		  					</form:form>
						</div>
				
					</div>
				</div>
				<img src = "/images/calculating-bills.jpg" class="card-img-top" alt="card-img-top">
			</div>
			<div class = "col-md-4" id = "cust-col">
				<div class = "text-info">
					<div class = "pt-5">
					<p class = "h4">Commission/Misc.</p>
					</div>
				</div>
				<div class = "pt-3">
					<p class = "h5">
						Take your net
						yearly income,
						and divide it by 12.
						This category applies
						if you get paid
						irregularly.
					</p>
					<div class = "row h-100 justify-content-center align-items-center">
						<div class="form-floating mb-3">
							<form:form action = "/misc" method = "post" modelAttribute = "income">
							
							<form:input path = "user" type = "hidden" value = "${oneUser.id}"/>
							
		  					<form:label for="floatingInput" path = "income" class = "text-black-50">Occupation</form:label>
							<form:input type="text" path = "source" class="form-control"/>
		  					<form:errors path = "source" class = "text-danger"/>
							
		  					<form:label for="floatingInput" path = "income" class = "text-black-50">Commission/Misc. Pay</form:label>
		  					<form:input type="number" path = "income" class="form-control"/>
		  					<form:errors path = "income" class = "text-danger"/>
		  				
		  					<div class = "pt-3">
		  						<input type = "submit" value = "Confirm Misc. Income" class = "btn btn-warning"/>
		  					</div>
		  				
		  					</form:form>
						</div>
				
					</div>
				</div>
				<img src = "/images/use-your-brain.jpg" class="card-img-top" alt="card-img-top">			
			</div>
		</div>
	</div>
</body>
</html>