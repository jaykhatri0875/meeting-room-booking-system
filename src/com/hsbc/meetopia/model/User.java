package com.hsbc.meetopia.model;

import java.util.UUID;

public class User {

	enum Role {
		ADMIN, MANAGER, MEMBER
	}

	private final String uID;
	private String name;
	private String email;
	private String phone;
	private Role role;
	private int credits;

	public User(String name, String email, String phone, Role role, int credits) {
		super();
		this.uID = generateUID();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.credits = credits;
	}

	public String generateUID() {
		return UUID.randomUUID().toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getuID() {
		return uID;
	}

}