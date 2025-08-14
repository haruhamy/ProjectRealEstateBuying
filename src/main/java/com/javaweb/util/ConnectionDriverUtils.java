package com.javaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDriverUtils {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "titansword";

	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
