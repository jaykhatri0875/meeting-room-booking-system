package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.model.User;

public interface UserDAO {

	static UserDAOImpl getUserDAO() {
		return new UserDAOImpl();
	}

	User saveUser(User user);

	User fetchUserByUID(String uID);

	Collection<User> fetchUsers();

}
