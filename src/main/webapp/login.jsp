<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<!-- <h1>Successfully Registered... You can Login here</h1> <br><br> -->
<div class="container " >
	<div class="row">
	
	<div class="col-md-4 offset-md-4">
	
	<div class="card">
	<div class="card-header primary-background text-center">
		<p>	<h2> Login</h2></p>
	</div>
	
	
	<div class="card-body">
	
<form action="Loginservlet" method=post>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="user_email" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="user_password" placeholder="Password">
  </div>
 
  <div class="text-center">
  <button type="submit" class="btn btn-primary ">Submit</button>
  </div>
</form>
		
	</div>
	
	</div>
	
	
	</div>
	
	</div>
	
	</div>
	
</body>
</html>