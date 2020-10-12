package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.User;

public interface UserService {

	static UserService getInstance() {
		return new UserServiceImpl();
	}

	User saveUser(User user);

	User fetchUserByUID(String uID);

	User fetchUserByName(String name);

	User loginUser(String uID, String email);

	Collection<User> fetchUsers();

}