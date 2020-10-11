package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.dao.UserDAO;
import com.hsbc.meetopia.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO dao = UserDAO.getUserDAO();

	@Override
	public User saveUser(User user) {
		return this.dao.saveUser(user);
	}

	@Override
	public User fetchUserByUID(String uID) {
		return this.dao.fetchUserByUID(uID);
	}

}
