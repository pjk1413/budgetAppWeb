<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.App.Defaults" %>
<%@ page import="com.User.User" %>

<%User user = (User)session.getAttribute("user"); %>

<link
  rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
  integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
  crossorigin="anonymous"
/>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><% out.print(Defaults.app_name + " - Set Income"); %></title>
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
            <a class="nav-link" href="#"
              >Home<span class="sr-only">(current)</span></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Income</a>
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
    
    <div class="card w-50 mx-auto mt-5">
  <h5 class="card-header">Featured</h5>
  <div class="card-body">
    <h5 class="card-title">Enter Annual Income Below</h5>
    <p class="card-text">Enter average hours worked and hourly salary below</p>
    <form action="SetIncomeHourly" method="POST">
    	<div class="form-group">
    		<input class="form-control my-2" type="text" name="hours" id="hours" placeholder="Enter average hours worked">
    		<input class="form-control my-2" type="text" name="wage" id="wage" placeholder="Enter hourly wage">
    	</div>
    	<button class="btn btn-primary" type="submit">Submit</button>
    </form>
    
  </div>
</div>

</body>
</html>