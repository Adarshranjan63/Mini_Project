package com.tech.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tech.Dao.recordDao;
import com.tech.Entities.Record;


@WebServlet("/Managementservlet")
public class Management extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("user_request");
		String description = request.getParameter("user_description");
		String dept = request.getParameter("user_deptartment");
		String date = request.getParameter("user_date");
		
		HttpSession session= request.getSession();
		String email = (String)session.getAttribute("email");
		System.out.println(email);
		System.out.println(date);
		
		Record record = new Record(title,description,email,date,dept);
	
		
		recordDao dao = new recordDao();
		int value = dao.saveRecord(record);
		if(value==1) System.out.println("done"); 
		else System.out.println("Not done");
		response.sendRedirect("management.jsp");
		
		
		
	}

}
