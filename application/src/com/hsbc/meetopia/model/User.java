package com.hsbc.meetopia.model;

import java.util.UUID;

public class User {

	private final String uID;
	private String name;
	private String email;
	private long phone;
	private String role;
	private int credits = 0;

	public User(String name, String email, long phone, String role) {
		super();
		this.uID = generateUID();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role.toLowerCase();
		if (role.toLowerCase() == "manager") {
			this.credits = 2000;
		}
	}

	public User(String uID, String name, String email, long phone, String role, int credits) {
		super();
		this.uID = uID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.credits = credits;
	}

	public String generateUID() {
		return UUID.randomUUID().toString().replaceAll("[\\s\\-()]", "").substring(0, 5).toUpperCase();
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
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