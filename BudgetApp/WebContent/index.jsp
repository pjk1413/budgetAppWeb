<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="com.App.Defaults" %>

<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<%  session.setAttribute("signInAttempt", null); %>
<meta charset="ISO-8859-1">
<title><% out.print(Defaults.app_name); %> - Sign Up</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"><% out.print(Defaults.app_name); %></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="user_sign_in.jsp">Sign Up</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"></a>
            </li>
          </ul>
        </div>
      </nav>


      <div class="row h-100">
        <div class="col"></div>
        <div class="col my-auto">
            <form class="" action="SignInServlet" method="POST">
                <div class="form-group">
                  <label for="email">Email address</label>
                  <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp">
                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div> 
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="form-group form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Remember me</label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <p id="error" name="error"><% out.print(Defaults.nullCheck(String.valueOf(request.getAttribute("error")))); %></p>
              </form>
        </div>
        
        <div class="col"></div>
      </div>

</body>
</html>