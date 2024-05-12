package com.tech.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tech.Entities.user;
import com.tech.Helper.ConnectionProvider;

public class userDao {
	
	public int   saveUser(user u)
	{
		int execute=0;
		String q="insert into user(email,password,role) values(?,?,?)";
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(q);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getRole());
			
			execute = pstmt.executeUpdate();
			System.out.println(execute);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return execute;
	}
	
	public user getUserFromEmailAndPassword(String email,String password)
	{
		user u = new user();
		try {
		String q = "select*from user where email =? and password=?";
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(q);
		
		pstmt.setString(1,email);
		pstmt.setString(2, password);
		ResultSet set = pstmt.executeQuery();
		
			if(set.next())
			{
				u.setEmail(set.getString(1));
				u.setPassword(set.getString(2));
				u.setRole(set.getString(3));
			}
			else System.out.println("User doesn't exists.......");
		} catch (SQLException e) {
			System.out.println("User doesn't exists....");
			
			e.printStackTrace();
		}
		return u;
	}
}
