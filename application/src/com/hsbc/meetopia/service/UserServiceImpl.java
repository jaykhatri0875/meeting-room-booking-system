package com.hsbc.meetopia.service;

import java.util.Collection;

/*
	user service layer 
	it calls userDAO layer and passes parameters if details are valid
*/
import com.hsbc.meetopia.dao.UserDAO;
import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO dao = UserDAO.getInstance();

	@Override
	public User saveUser(User user) {
		User user1 = null;
		try {
			user1 = this.dao.saveUser(user);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return user1;
	}

	@Override
	public User fetchUserByUID(String uID) {
		User user1 = null;
		try {
			user1 = this.dao.fetchUserByUID(uID);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return user1;
	}

	@Override
	public User loginUser(String uID, String email) {
		User user = fetchUserByUID(uID);
		if (user != null) {
			if (user.getEmail().equals(email.toLowerCase())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public Collection<User> fetchUsers() {
		Collection<User> users = null;
		try {
			users = this.dao.fetchUsers();
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

}
