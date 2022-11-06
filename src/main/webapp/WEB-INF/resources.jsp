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
<title>Resources</title>
</head>
<body>
	<div class = "container-lg">
		<div class = "row justify-content-md-center">
			<nav class="navbar navbar-expand-xl navbar-light bg-light">
			  <div class="container-fluid">
			  	<h1 class="text-success">BudgetMiracle</h1>
			  </div>
			  <div class = "container-fluid">
			  	<h2 class = "text-success">Resources</h2>
			  </div>
			  <div class = "container-fluid">
			  	<a href = "/logout" class = "text-success">Logout</a> 
			  	<a href = "/dashboard" class = "text-success">Home</a> 
			  </div>
			</nav>
		</div>
		<div class = "col-md-10">
			<div class = "p-4">
				<div class = "text-muted">
					<p class = "h3">Links</p>
				</div>
				<ul class="list-grou[]">
				  <li class="list-group-item"><a href = "https://www.youtube.com/watch?v=9Iuiyj0VkZw" class = "btn btn-link btn-lg">The $27.40 Trick</a> - Fun tip that you can do, but takes self discipline</li>
				  <li class="list-group-item"><a href = "https://www.investopedia.com/articles/younginvestors/08/eight-tips.asp" class = "btn btn-link btn-lg">8 Financial Tips For Young Adults</a> - Great article for tips on managing you money</li>
				  <li class="list-group-item"><a href = "https://www.creditkarma.com/" class = "btn btn-link btn-lg">Credit Karma</a> - Wonderful resource that can help you build your credit</li>
				  <li class="list-group-item"><a href = "https://www.moneyhelper.org.uk/en/everyday-money/budgeting/beginners-guide-to-managing-your-money" class = "btn btn-link btn-lg">Money Helper</a> - A how to on budgeting</li>
				  <li class="list-group-item"><a href = "https://www.youtube.com/watch?v=HQzoZfc3GwQ" class = "btn btn-link btn-lg">50/30/20 Rule</a> - Great for people who are new to personal finances</li>
				  <li class="list-group-item"><a href = "https://www.youtube.com/c/WhiteBoardFinance" class = "btn btn-link btn-lg">WhiteBoard Finance</a> - Same person that does the 50/30/20 Rule</li>
				</ul>
			</div>
			<div class = "text-muted">
				<div class = "pt-4">
					<p class = "h5">All of the resources above are solid. If you or someone you know are suffering financially and need help, 
					look into talking to a financial counselor. There are plenty available and many are free. I wish you luck on your financial journey.</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>