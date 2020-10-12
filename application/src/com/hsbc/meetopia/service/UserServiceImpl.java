package com.hsbc.meetopia.service;
/*
	user service layer 
	it calls userDAO layer and passes parameters if details are valid
*/
import com.hsbc.meetopia.dao.UserDAO;
import com.hsbc.meetopia.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO dao = UserDAO.getInstance();

	@Override
	public User saveUser(User user) {
		return this.dao.saveUser(user);
	}

	@Override
	public User fetchUserByUID(String uID) {
		return this.dao.fetchUserByUID(uID);
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

}
