package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.User;

public interface UserDAO {

	static UserDAO getInstance() {
		return new UserDAOImpl();
	}

	User saveUser(User user) throws ConnectionFailedException;

	User fetchUserByUID(String uID) throws ConnectionFailedException;

	Collection<User> fetchUsers() throws ConnectionFailedException;
}
