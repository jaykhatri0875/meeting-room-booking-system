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

}
