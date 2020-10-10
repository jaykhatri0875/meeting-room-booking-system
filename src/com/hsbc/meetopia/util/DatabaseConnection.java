package com.hsbc.meetopia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meetopia", "root", "shivani");
        } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
        return con;
    }
    
	/*
	 * private static final String DB_URL =
	 * "jdbc:mysql://db4free.net:3306/codefury"; private static final String USER =
	 * "codefury"; private static final String PASS = "codefury";
	 * 
	 * public static Connection getRemoteConnection() { try {
	 * Class.forName(JDBC_DRIVER); con = DriverManager.getConnection(DB_URL, USER,
	 * PASS); return con; } catch (Exception e) { e.printStackTrace(); } return
	 * null; }
	 */
}
