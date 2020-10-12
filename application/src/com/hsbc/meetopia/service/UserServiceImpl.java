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
			if (validateEmailAddress(user.getEmail()) && validatePhone(user.getPhone())) {
				user1 = this.dao.saveUser(user);
			}
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
	public User fetchUserByName(String name) {
		User user1 = null;
		try {
			user1 = this.dao.fetchUserByName(name);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return user1;
	}

	@Override
	public User loginUser(String uID, String email) {
		User user = fetchUserByUID(uID);
		if (user != null && validateEmailAddress(email)) {
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

	/**
	 * Matching the given email address with regular expression
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean validateEmailAddress(String email) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		return email.matches(regex);
	}

	/**
	 * Matching the given phone number with regular expression
	 * 
	 * @param phone
	 * @return boolean
	 */
	public boolean validatePhone(long phone) {
		String phoneNum = "" + phone;
		String regex = "^[6-9]\\d{9}$";
		return phoneNum.matches(regex);
	}

}
