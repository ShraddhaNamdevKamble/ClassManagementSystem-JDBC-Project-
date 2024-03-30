package com.classmanagementsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	private MyConnection()
	{
		
	}
	
	private static Connection connection;
	public static Connection getConncetion() throws Exception
	{
		if(connection==null);
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/classmanagementsystem","root","root");
		}
		return connection;
	}
}
