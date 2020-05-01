<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.App.Defaults" %>
<%@ page import="com.User.User" %>

<%
	User user = (User) session.getAttribute("user");
%>

<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><% out.print(user.getFullName()); %> - Home</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#"><% out.print(Defaults.app_name); %></a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="user_home.jsp"
              >Home<span class="sr-only">(current)</span></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="income_home.jsp">Income</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Savings</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Deductions</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Taxes</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="text-center">
      <h4>Welcome <% out.print(user.getFirstName()); %></h4>
    </div>
    <div class="row mt-5">
      <div class="col-md-3">
        <div class="mx-auto card" style="width: 18rem;">
          <img src="./Images/income.jpg" class="card-img-top" alt="..." />
          <div class="card-body">
            <h5 class="card-title">Income</h5>
            <p class="card-text">
              Current Income: <%out.print(user.getIncomeString()); %>
            </p>
            <a href="income_home.jsp" class="btn btn-primary">View Income Details</a>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="mx-auto card" style="width: 18rem;">
          <img src="./Images/taxes.jpg" class="card-img-top" alt="..." />
          <div class="card-body">
            <h5 class="card-title">Taxes</h5>
            <p class="card-text">
              Current Total Taxes Paid: <% out.print(user.getTotalFederalTaxesString()); %>
            </p>
            <a href="#" class="btn btn-primary">Edit Taxes</a>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card mx-auto" style="width: 18rem;">
          <img src="./Images/savings.png" class="card-img-top" alt="..." />
          <div class="card-body">
            <h5 class="card-title">Savings</h5>
            <p class="card-text">
              Current Savings: $0
            </p>
            <a href="#" class="btn btn-primary">Edit Savings</a>
          </div>
        </div>
      </div>

      <div class="col-md-3">
        <div class="card mx-auto" style="width: 18rem;">
          <img src="./Images/deductions.png" class="card-img-top" alt="..." />
          <div class="card-body">
            <h5 class="card-title">Deductions</h5>
            <p class="card-text">
              Current Deductions: 
            </p>
            <a href="#" class="btn btn-primary">Edit Deductions</a>
          </div>
        </div>
      </div>
    </div>

</body>
</html>