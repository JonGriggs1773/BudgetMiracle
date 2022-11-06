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
<title>Dash Board</title>
</head>
<body>
	<div class = "container-lg">
	
		<div class = "row justify-content-md-center">
			<nav class="navbar navbar-expand-xl navbar-light bg-light">
			  <div class="container-fluid">
			  	<h1 class="text-success">BudgetMiracle</h1>
			  </div>
			  <div class = "container-fluid">
			  	<h2 class = "text-success">Welcome, <c:out value = "${oneUser.firstName}"/></h2>
			  </div>
			  <div class = "container-fluid">
			  	<a href = "/logout" class = "text-success">Logout</a> 
			  	<a href = "/late/income/input" class = "text-success">Add Your Income</a> 
			  	<a href = "/resources" class = "text-success">Resources</a> 
			  </div>
			</nav>
		</div>
		
		<div class = "col-md-6">
			<div class="alert alert-primary" role="alert">
			  <p class = "h5">
			  	Your Monthly Income: $<c:out value = "${userIncome.income}"/>.00 
			  	<a href = "/edit/income/page/${userIncome.id}" class = "btn btn-outline-success">Edit Income</a>
			  </p>
			</div>
		</div>
		
		<div class = "col-md-10">
			<div class = "pt-4">
				<h3 class = "text-muted">Bills</h3>
			</div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Amount</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach var = "bill" items = "${allBills}">
					<tr>
						<td>${bill.name}</td>
						<td>${bill.amount}</td>
						<td><a href = "/edit/bill/page/<c:out value = "${bill.id}"/>" class = "btn btn-dark btn-sm">Edit</a></td>
						<td>
							<form action="/delete/bill/${bill.id}" method="post" >
							    <input type="hidden" name="_method" value="delete" >
							    <input type="submit" value="Delete" class = "btn btn-outline-danger btn-sm">
							</form>
						</td>
					</tr>
				</c:forEach>
			  </tbody>
			  <tfoot>
			  	<tr>
			  		<td><a href = "/add/bill" class = "btn btn-danger">Add Bill</a></td>
			  	</tr>
			  </tfoot>
			</table>
		</div>
		
		<div class = "col-md-10">
			<div class = "pt-4">
				<h3 class = "text-muted">Expenses</h3>
			</div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Amount</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach var = "expense" items = "${allExpenses}">
					<tr>
						<td>${expense.name}</td>
						<td>${expense.amount}</td>
						<td><a href = "/edit/expense/page/<c:out value = "${expense.id}"/>" class = "btn btn-dark btn-sm">Edit</a></td>
						<td>
							<form action="/delete/expense/${expense.id}" method="post" >
							    <input type="hidden" name="_method" value="delete" >
							    <input type="submit" value="Delete" class = "btn btn-outline-danger btn-sm">
							</form>
						</td>
					</tr>
				</c:forEach>
			  </tbody>
			  <tfoot>
			  	<tr>
			  		<td><a href = "/add/expense" class = "btn btn-warning">Add Expense</a></td>
			  	</tr>
			  </tfoot>
			</table>
		</div>
		
		<div class = "col-md-10">
			<div class = "pt-4">
				<h3 class = "text-muted">Funds</h3>
			</div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Amount</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach var = "fund" items = "${allFunds}">
					<tr>
						<td>${fund.name}</td>
						<td>${fund.amount}</td>
						<td><a href = "/edit/fund/page/<c:out value = "${fund.id}"/>" class = "btn btn-dark btn-sm">Edit</a></td>
						<td>
							<form action="/delete/fund/${fund.id}" method="post" >
							    <input type="hidden" name="_method" value="delete" >
							    <input type="submit" value="Delete" class = "btn btn-outline-danger btn-sm">
							</form>
						</td>
					</tr>
				</c:forEach>
			  </tbody>
			  <tfoot>
			  	<tr>
			  		<td><a href = "/add/fund" class = "btn btn-info">Add Fund</a></td>
			  	</tr>
			  </tfoot>
			</table>
		</div>
		
		<div class = "col-md-6">
			<div class="alert alert-primary" role="alert">
				  <p class = "h5">
				  	Calculated Income: $<c:out value = "${calculatedIncome}"/>.00 
				  </p>
			</div>
			<div class = "p-4"></div>
		</div>
	</div>
</body>
</html>

























