package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.User;

public interface UserService {

	static UserService getInstance() {
		return new UserServiceImpl();
	}

	User saveUser(User user);

	User fetchUserByUID(String uID);

	Collection<User> fetchUsers();

}