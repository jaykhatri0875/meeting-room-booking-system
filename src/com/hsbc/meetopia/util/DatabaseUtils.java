package com.hsbc.meetopia.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {

	private static Connection conn;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * Local database connection
	 * 
	 * @disclaimer Edit as per your credentials
	 */
	private static final String LOCAL_DB_URL = "jdbc:mysql://localhost:3306/meetopia";
	private static final String LOCAL_USER = "root";
	private static final String LOCAL_PASS = "shivani";

	public static Connection getLocalConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(LOCAL_DB_URL, LOCAL_USER, LOCAL_PASS);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Remote database for testing (refer: Database.txt)
	 * 
	 * @disclaimer Should not be edited
	 */
	private static final String DB_URL = "jdbc:mysql://db4free.net:3306/codefury";
	private static final String USER = "codefury";
	private static final String PASS = "codefury";

	public static Connection getRemoteConnection() {
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
