package com.tech.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tech.Entities.Record;
import com.tech.Helper.ConnectionProvider;

public class recordDao {
	
	public int saveRecord(Record record)
	{
		int execute=0;
		try {
			Connection connection = ConnectionProvider.getConnection();
			String q= "insert into approval (title,description,request_by,request_date,request_dept) values(?,?,?,?,?)";
			PreparedStatement pstmt= connection.prepareStatement(q);
			pstmt.setString(1, record.getTitle());
			pstmt.setString(2, record.getDescription());
			pstmt.setString(3, record.getRequest_by());
			pstmt.setString(4, record.getRequest_date());
			pstmt.setString(5, record.getRequest_dept());
			System.out.println("hehehe");
			execute = pstmt.executeUpdate();
			System.out.println("hahaah");
		} 
		catch (Exception e) {
			System.out.println("Error in saving the record");
			e.printStackTrace();
		}
		return execute;
	}
	
	public ResultSet getRecord(String email)
	   {   
		ResultSet s=null;
		   try {
			   Connection connection = ConnectionProvider.getConnection();
			   String q="select * from approval where request_by=?  ";
			   PreparedStatement st=connection.prepareStatement(q);
			   st.setString(1, email);
			   s=st.executeQuery(); 
			   
		   }
		   catch(Exception e)
		   {
			    System.out.println("eror");
			  e.printStackTrace();
			  
		   }
		   return s;
	   }

	public ResultSet getFinanceRecord()
	   {   
		ResultSet s=null;
		   try {
			   Connection connection = ConnectionProvider.getConnection();
			   String q="select * from approval where request_dept=?  ";
			   PreparedStatement st=connection.prepareStatement(q);
			   st.setString(1, "Finance");
			   s=st.executeQuery(); 
			   
		   }
		   catch(Exception e)
		   {
			    System.out.println("error");
			  e.printStackTrace();
			  
		   }
		   return s;
	   }
	
	public int saveApprovalRecord(int reqId,String approval_person ,String approval_date ,String status)
	{
		String q = "update approval set approval_person=? ,approval_date=?,status=? where request_id=?";
		Connection connection = ConnectionProvider.getConnection();
		int execute=0;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(q);
			pstmt.setString(1, approval_person);
			pstmt.setString(2, approval_date);
			pstmt.setString(3, status);
			pstmt.setInt(4, reqId);
			
			execute =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("erroroorororoor");
			e.printStackTrace();
		}
		return execute;
	}
	
	public ResultSet getLegalRecord()
	   {   
		ResultSet s=null;
		   try {
			   Connection connection = ConnectionProvider.getConnection();
			   String q="select * from approval where request_dept=?  ";
			   PreparedStatement st=connection.prepareStatement(q);
			   st.setString(1, "Legal");
			   s=st.executeQuery(); 
			   
		   }
		   catch(Exception e)
		   {
			    System.out.println("error in Legal record");
			  e.printStackTrace();
			  
		   }
		   return s;
	   }
	public int countApproveRequestForFinance() {
	    int count = 0;
	    String q = "select count(*) as count from approval where request_dept='Finance' and status='Approved'";
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(q);
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in counting approve requests");
	        e.printStackTrace();
	    }
	    return count;
	
	}
	
	public int countDeclineRequestForFinance() {
	    int count = 0;
	    String q = "select count(*) as count from approval where request_dept='Finance' and status='Declined'";
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(q);
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in counting approve requests");
	        e.printStackTrace();
	    }
	    return count;
	
	}
	
	public int countPendingRequestForFinance() {
	    int count = 0;
	    String q = "select count(*) as count from approval where request_dept='Finance' and status='Pending'";
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(q);
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in counting approve requests");
	        e.printStackTrace();
	    }
	    return count;
	
	}
	
	//Legal summry section
	
	public int countApproveRequestForLegal() {
	    int count = 0;
	    String q = "select count(*) as count from approval where request_dept='Legal' and status='Approved'";
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(q);
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in counting approve requests");
	        e.printStackTrace();
	    }
	    return count;
	
	}
	
	public int countDeclineRequestForLegal() {
	    int count = 0;
	    String q = "select count(*) as count from approval where request_dept='Legal' and status='Declined'";
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(q);
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in counting approve requests");
	        e.printStackTrace();
	    }
	    return count;
	
	}
	
	public int countPendingRequestForLegal() {
	    int count = 0;
	    String q = "select count(*) as count from approval where request_dept='Legal' and status='Pending'";
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(q);
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in counting approve requests");
	        e.printStackTrace();
	    }
	    return count;
	
	}
}
