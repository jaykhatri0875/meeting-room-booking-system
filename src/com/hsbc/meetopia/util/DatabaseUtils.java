package com.hsbc.meetopia.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {

	private static Connection conn;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://db4free.net:3306/codefury";
	private static final String USER = "codefury";
	private static final String PASS = "codefury";

	public static Connection getConnection() {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
