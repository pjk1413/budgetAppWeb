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
<title><% out.print(Defaults.app_name + " - Income"); %></title>
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

    <div class="text-center">
      <h4>Income</h4>
    </div>
    <div class="row mt-5">
      
      <div class="col-md-11 mx-auto">
        
            
            <div class="row">
                <div class="col mx-auto my-2">
                    <div class="card mx-auto" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Income</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Current Annual Income Before Taxes</h6>
                          <p class="card-text"><% out.print(user.getIncomeString()); %></p>
                          <a href="user_set_income.jsp" class="card-link">Set Income</a>
                          <!--  <a href="#" class="card-link">Another link</a> -->
                        </div>
                      </div>
                </div>
                <div class="col mx-auto my-2">
                    <div class="card mx-auto" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Current Investments</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Manage Investments</h6>
                          <p class="card-text">Current Investment Income: <% out.print(user.getTotalInvestmentString()); %></p>
                          <a href="income_manage_investments.jsp" class="card-link">Manage Investments</a>
                    
                        </div>
                      </div>
                </div>
                <div class="col">
                    <div class="card mx-auto my-2" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Current Expenses</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Manage Expenses</h6>
                          <p class="card-text">Current Total Expenses: <% out.print(user.getTotalExpenseString()); %></p>
                          <a href="income_manage_expenses.jsp" class="card-link">Manage Expenses</a>
                      
                        </div>
                      </div>
                </div>
                <div class="col">
                    <div class="card mx-auto my-2" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Taxes Currently Paid</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Total Federal Taxes</h6>
                          <p class="card-text"><% out.print(user.getTotalFederalTaxesString()); %></p>
                          <a href="income_taxes.jsp" class="card-link">View Tax Analysis</a>
               
                        </div>
                      </div>
                </div>
            </div>


         
      </div>
      
    </div>


</body>
</html>