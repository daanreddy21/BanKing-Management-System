package com.bank.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	static String url="jdbc:mysql://localhost:3306/banking";
	static String user="root";
	static String pass="Daan2105@";
	
	public static Connection getconnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user,pass);
	}

	
}
