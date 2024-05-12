package com.tech.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.Session;
import com.tech.Dao.recordDao;
import com.tech.Dao.userDao;
import com.tech.Entities.user;

@WebServlet("/Loginservlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		
		userDao dao = new userDao();
		user u = dao.getUserFromEmailAndPassword(email, password);
		
		String role = u.getRole();
		
		
		if(role.equals("Management"))
		{
			resp.sendRedirect("management.jsp");
		}
		else if(role.equals("Finance"))
		{
			resp.sendRedirect("finance.jsp");
		}
		else if(role.equals("Legal"))
		{
			resp.sendRedirect("legal.jsp");
		}
				
	}

}
