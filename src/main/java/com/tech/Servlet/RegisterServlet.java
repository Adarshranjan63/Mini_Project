package com.tech.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.Dao.userDao;
import com.tech.Entities.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet  extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		String role = req.getParameter("user_role");
		
		user u = new user(email,password,role);
		userDao uDao= new userDao();
		int value = uDao.saveUser(u);
		System.out.println(value);
		if(value==1)
		 {
			 out.println("<h1>Successfully Registered...</h1>");
			 resp.sendRedirect("login.jsp");
		 }
		 else 
		 {
			 out.println("<h1>Something went wrong !!</h1>");
		 }
		
	}
	
}
