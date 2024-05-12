<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<h1 style="text-align: center;">If you are allready register Do login here .....</h1><br><br>
<div class="container">
	
		<div class="text-center">
		  <a href="login.jsp"> <button type="submit" class="btn btn-primary" id="submitBtn">Login</button></a>
		  </div>
</div> <br><br>
		
<div class="container"> 
	
	<div class="row">
	
	<div class="col-md-6 offset-md-3">
	
	
	<div class="card">
	
	<div class="card-header text-center primary-background">
	<p><br> <h2>Register Here</h2></p>
	</div>
	
	
	<div class="card-body">
	
	<form action="RegisterServlet" method="post">
	
	
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="user_email" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="user_password" placeholder="Password">
  </div>
  
 <div class="form-group">
    <label for="exampleInputPassword1">Role</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="user_role" placeholder="Role..">
  </div>
 
 
 <div class="container text-center" id="loader" style="display: none;">
 
 <span class="fa fa-refresh fa-spin fa-3x"></span>
 <h4>Please wait</h4>
 
 </div>
  
  <div class="text-center">
  <button type="submit" class="btn btn-primary" id="submitBtn">Submit</button>
  </div>
 
</form>
	
	</div>
	
	</div>
	
	
	</div>
	
	</div>
	
	
	</div>
	
	
	
</body>
</html>