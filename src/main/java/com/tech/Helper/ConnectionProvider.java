package com.tech.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public  class ConnectionProvider {
	
	private static Connection connection;
	
		public static Connection getConnection() 
		{
			try 
			{
				if(connection==null)
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String path = "jdbc:mysql://localhost:3306/project1";
					String userName="root";
					String password = "157836";
					
					connection = DriverManager.getConnection(path, userName, password);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			System.out.println(connection);
			return connection;
		}
		
		
}
