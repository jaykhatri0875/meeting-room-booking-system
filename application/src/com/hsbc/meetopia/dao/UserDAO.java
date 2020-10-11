package com.hsbc.meetopia.dao;

import com.hsbc.meetopia.model.User;

public interface UserDAO {

	static UserDAO getInstance() {
		return new UserDAOImpl();
	}

	User saveUser(User user);

	User fetchUserByUID(String uID);

}
