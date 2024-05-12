<%@page import="java.sql.ResultSet"%>
<%@page import="com.tech.Dao.recordDao"%>
<%@page import="com.tech.Entities.Record"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Management Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container ">
		<div class="row">

			<div class="col-md-6">

				<div class="card">
					<div class="card-header primary-background text-center">
						<p>
						<h2>Request Form</h2>
						</p>
					</div>


					<div class="card-body">

						<form action="Managementservlet" method=post>
							<div class="form-group">
								<label for="exampleInputEmail1">Request Title</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="user_request"
									placeholder="Enter your request" required="required">

							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1">Project
									Description</label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									rows="5" cols="5" name="user_description" required="required"></textarea>
							</div>
							<label for="dep">Select Departement</label> 
							<select name="user_deptartment" id="dep" class="form-control" required="required" >
							 	<option value="">Select Department</option>
								<option value="Finance" >Finance</option>
								<option value="Legal">Legal</option>
							</select>
							<div>
								<input type="hidden" name="user_date"  value="<%=new Date().toString()%>" >
								
							</div>

							<br><br>
							<div class="text-center">
								<button type="submit" class="btn btn-primary " name="user_submit" value="requested">Send
									Request</button>
							</div>
						</form>

					</div>

				</div>


			</div>
			
			<div class="col-md-6">
			
			<div class="card">
					<div class="card-header primary-background text-center">
						<p>
						<h2>Summery Section</h2>
						</p>
					</div>


					<div class="card-body">

						<p><h4>Finance Departement</h4></p>
						 <b style="color: green;"> Approved Requests : <%=new recordDao().countApproveRequestForFinance() %></b><br>
						 <b style="color: red;"> Deny Requests :  <%=new recordDao().countDeclineRequestForFinance() %></b><br>
						 <b style="color: blue;"> Pending Requests : <%=new recordDao().countPendingRequestForFinance() %> </b><br>
						<hr>
						<p><h4>Legal Departement</h4></p>
						
						<b style="color: green;">Approved Requests : <%=new recordDao().countApproveRequestForLegal() %> </b><br>
						 <b style="color: red;">Deny Requests : <%=new recordDao().countDeclineRequestForLegal() %> </b><br>
						 <b style="color: blue;">Pending Requests :<%=new recordDao().countPendingRequestForLegal() %></b> <br>

					</div>
					

				

				</div>
			</div>

		</div>

	</div>
	<br><br>
	
		<div class="container">
			<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">Request ID</</th>
	      <th scope="col">Request Title</th>
	      <th scope="col">Description</th>
	      <th scope="col">Request By</th>
	      <th scope="col">Request Date</th>
	      <th scope="col">Request Department</th>
	      <th scope="col">Approval Person</th>
	      <th scope="col">Approval Date</th>
	      <th scope="col">status</th>
	    </tr>
	  </thead>
	  <tbody>
	   
 	<%
			String email=(String)session.getAttribute("email");
			recordDao dao = new recordDao();
			ResultSet set=dao.getRecord(email);
			
			while(set.next())
			{
				%>
				<tr>
			      <td ><%=set.getInt(1)+""%></td>
			      <td ><%=set.getString(2)%></td>
			      <td ><%=set.getString(3)%></td>
			      <td ><%=set.getString(4)%></td>
			      <td ><%=set.getString(5)%></td>
			      <td ><%=set.getString(6)%></td>
			      <td ><%=set.getString(7)%></td>
			      <td ><%=set.getString(8)%></td>
			      <td ><%=set.getString(9)%></td>
			      </tr>
				<%
			}
	%>
	
	  </tbody>
	</table>
		</div>
</body>
</html>