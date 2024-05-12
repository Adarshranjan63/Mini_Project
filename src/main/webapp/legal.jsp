<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="com.tech.Dao.*" %>
<%@page import ="com.tech.Helper.ConnectionProvider" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Legal Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center;">LEGAL DEPARTEMENT DASHBOARD</h1> <br>
<form action="ActionLegalServlet" method="post">
    <div class="container">
			<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">Request ID</</th>
	      <th scope="col">Request Title</th>
	      <th scope="col">Description</th>
	      <th scope="col">Request By</th>
	      <th scope="col">Request Date</th>
	      <th scope="col">Approval Person</th>
	      <th scope="col">Approval Date</th>
	      <th scope="col">status</th>
	    </tr>
	  </thead>
	  <tbody>
	   
 	<%
			String email=(String)session.getAttribute("email");
			recordDao dao = new recordDao();
			ResultSet set=dao.getLegalRecord();
			
			while(set.next())
			{
				%>
				<tr>
			      <td ><%=set.getInt(1)+""%></td>
			      <td ><%=set.getString(2)%></td>
			      <td ><%=set.getString(3)%></td>
			      <td ><%=set.getString(4)%></td>
			      <td ><%=set.getString(5)%></td>
			      <td ><%=set.getString(7)%></td>
			      <td ><%=set.getString(8)%></td>
			      <td >
			      <%
			      		if(!set.getString(9).equals("Approved") &&  !set.getString(9).equals("Declined"))
			      		{
			      	%>
			      			<button type="submit" class="btn btn-success" name="approve" value="<%=set.getInt(1)+""%>">Approve</button>
                          	<button type="submit"  class="btn btn-danger" name="decline"value="<%=set.getInt(1)+""%>">Decline</button>
			      		<%	
			      		}
			      		else{
			      			%>
			      			<td ><h5><%=set.getString(9)%></h5></td>
			      			<%
			      		}
			      %>
                  </td>
			      
	            </tr>
			      
				<%
			}
	%>
	  </tbody>
	</table>
		</div>
</form>

</body>
</html>