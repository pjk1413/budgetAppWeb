<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.App.Defaults"%>
<%@ page import="com.User.User"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	User user = (User) session.getAttribute("user");
%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"> <%
 	out.print(Defaults.app_name);
 %>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="user_home.jsp">Home<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="income_home.jsp">Income</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Savings</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Deductions</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Taxes</a></li>
			</ul>
		</div>
	</nav>

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col">
			<div class="card mx-auto my-2">
				<div class="card-body">
					<h5 class="card-title">Add Investments</h5>
					<h6 class="card-subtitle mb-2 text-muted">Fill out the
						information below</h6>
					<form action="AddInvestmentServlet" method="POST">
						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<input value="true" type="checkbox" id="recurring" name="recurring" aria-label="Checkbox for following text input">
								</div>
							</div>
							<input id="investment" name="investment" type="text" class="form-control" placeholder="Amount">
							<input id="rate" name="rate" type="text" class="form-control" placeholder="Rate of Return">
						</div>
						<small id="investmentHelp" class="form-text text-muted mb-3">Check the box for recurring investments</small>
						<button type="submit" class="btn btn-primary">Add</button>
					</form>

				</div>
			</div>
		</div>
		<div class="col">
			<c:if test="${ user.getInvestments() != null }">
				<table class="table table-dark table-hover my-2 rounded-lg">
				</c:if>
					<caption>Current Investments</caption>
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">Amount</th>
							<th scope="col">Rate</th>
							<th scope="col">Recurring</th>
							<th scope="col">Options</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="investment" items="${user.getInvestments()}">
					
						<tr name="investments">
							<th scope="row">1</th>
							<td><c:out value="${investment.getAmount()}"></c:out></td>
							<td><c:out value="${investment.getRateOfReturn()}"/></td>
							<td><c:out value="${investment.getRecurring()}"/></td>
							<c:url value="RemoveInvestmentServlet" var="myURL"> 
								<c:param name = "removeAmount" value = "${investment.getAmount()}"/>
								<c:param name = "removeRateOfReturn" value = "${investment.getRateOfReturn()}"/>
							</c:url>
							
							<td><a href="<c:out value="${myURL}"/>"><button class="btn btn-secondary" type="button">Remove</button></a>
							</td> 
						</tr>
					</c:forEach>
					</tbody>
				</table>
		
		</div>
		<div class="col-md-2"></div>

	</div>


</body>
</html>