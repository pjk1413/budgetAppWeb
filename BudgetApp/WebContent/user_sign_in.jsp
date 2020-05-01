<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="com.App.Defaults" %>
<%@ page import="com.User.User" %>

<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign Up</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">
			<%
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
				<li class="nav-item active"><a class="nav-link" href="#">Home<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#">Income</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Savings</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Deductions</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Taxes</a></li>
			</ul>
		</div>
	</nav>


	<div class="row mt-5">

		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h3>Please fill out the form below</h3>
			<form method="POST" action="RegistrationServlet">
				<div class="form-row">
					<div class="col my-3 mx-3">
						<input type="text" id="firstName" name="firstName"
							class="form-control" placeholder="First name">
					</div>
					<div class="col my-3 mx-3">
						<input type="text" id="lastName" name="lastName"
							class="form-control" placeholder="Last name">
					</div>
				</div>
				
				<div class="form-row">
					<div class="col my-3 mx-3">
						<input type="text" id="income" name="income"
							class="form-control" placeholder="Annual Income">
					</div>
					<div class="col my-3 mx-3"> 
					<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <label class="input-group-text" for="filingStatus">Filing Status</label>
				  </div>
				  <select class="custom-select" id="filingStatus" name="filingStatus">
				    <option selected>Please Select...</option>
				    <option value="Married">Married</option>
				    <option value="Single">Single</option>
				    <option value="HeadOfHousehold">Head of Household</option>
				  </select>
				</div>
				</div>
				</div>
				
				<div class="form-row">
					<div class="col my-3 mx-3">
						<input type="text" id="email" name="email" class="form-control"
							placeholder="Email">
					</div>
					<div class="col my-3 mx-3">
						<input type="password" id="password" name="password"
							class="form-control" placeholder="Password">
					</div>
				</div>
				
				<hr>
				<div class="w-100">
				<h4>Address</h4>
				</div>
				
				<div class="form-row">
					<div class="col my-3 mx-3">
						<input type="text" id="street" name="street" class="form-control"
							placeholder="Street">
					</div>
					<div class="col my-3 mx-3">
						<input type="text" id="city" name="city"
							class="form-control" placeholder="City">
					</div>
				</div>
				
				<div class="form-row">  
					<div class="col my-3 mx-3">
						<input type="text" id="state" name="state" class="form-control"
							placeholder="Email">
					</div>
					<div class="col my-3 mx-3">
						<input type="text" id="zipcode" name="zipcode"
							class="form-control" placeholder="Zipcode">
					</div>
				</div>
				
				<div class="form-row">
					<div class="col">
						<sub class="mx-3">All data will be kept private</sub>
					</div>
					<div class="col text-right">
						<button class="btn btn-primary mr-3" type="submit">Submit</button>
					</div>
					<sub class="text-alert"></sub>
				</div>

			</form>
		</div>

		<div class="col-md-3"></div>
	</div>

</body>
</html>