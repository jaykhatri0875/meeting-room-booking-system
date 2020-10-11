package com.hsbc.meetopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import com.hsbc.meetopia.model.User;
import com.hsbc.meetopia.util.DatabaseUtils;

public class UserDAOImpl implements UserDAO {

	private static final String INSERT_QUERY = "insert into user(uid,name,email,phone,role,credits) values(?,?,?,?,?,?)";
	
	@Override
	public User saveUser(User user) {
		Connection connection = DatabaseUtils.getRemoteConnection();
		if (connection != null) {
			try (PreparedStatement pStmt = connection.prepareStatement(INSERT_QUERY)) {
				pStmt.setString(1, user.getuID());
				pStmt.setString(2, user.getName());
				pStmt.setString(3, user.getEmail());
				pStmt.setLong(4, user.getPhone());
				pStmt.setString(5, user.getRole());
				pStmt.setInt(6, user.getCredits());

				int recordsUpdated = pStmt.executeUpdate();
				if (recordsUpdated > 0) {
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("User not inserted");
		return null;
	}

	@Override
	public User fetchUserByUID(String uID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> fetchUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
