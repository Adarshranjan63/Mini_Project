package com.tech.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

import com.tech.Dao.recordDao;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String approve = request.getParameter("approve");
		String decline = request.getParameter("decline");
		HttpSession session = request.getSession();
		String approval_person=(String) session.getAttribute("email");
		recordDao dao = new recordDao();
		int value=0;
		
		if(approve!=null)
		{
			System.out.println("approve req");
			int reqId = Integer.parseInt(approve);
			
			value = dao.saveApprovalRecord(reqId,approval_person,new Date().toString(),"Approved");
		}
		else {
			System.out.println("decline req");
			int reqId = Integer.parseInt(decline);
			value = dao.saveApprovalRecord(reqId,approval_person,new Date().toString(),"Declined");
		}
		if(value==1) System.out.println("done");
		else System.out.println("Not done");
		
		response.sendRedirect("finance.jsp");
	}

}
