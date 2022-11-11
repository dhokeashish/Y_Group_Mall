package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {

	public static Connection getConnection() {
	

		Connection connection = null;
		
		//loading Driver Class
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" ~~driver class loaded successfully~~ ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//establishing the connection with mysql
		String url = "jdbc:mysql://localhost:3306/product?characterEncoding=latin1";
		try {
		connection = DriverManager.getConnection(url, "root", "Password@123");
		System.out.println(" ~~JDBC connection establish~~");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
			
	}
}