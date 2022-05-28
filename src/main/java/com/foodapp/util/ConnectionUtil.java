package com.foodapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	/**
	 * This method returns the database connection
	 * @throws ClassNotFoundException 
	 */
	public static Connection getConnection() throws ClassNotFoundException {

		String url = "jdbc:mysql://training-db.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/vkiruthika_db";
		String username = "vkiruthika";
		String password = "vkiruthika";
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect db");
		}

		return connection;
	}

	/**
	 * This method will close connection resources
	 */
	public static void close(Statement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
