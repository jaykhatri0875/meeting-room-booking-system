package com.hsbc.meetopia.model;

import java.util.UUID;

public class Meeting {

	enum Type {
		CLASSROOM_TRAINING, ONLINE_TRAINING, CONFERENCE_CALL, BUSINESS
	}

	private final String uID;
	private String title;
	private String startTime;
	private String endTime;
	private Type type;
	private User[] attendees;
	private String bookingId;

	public Meeting(String title, String startTime, String endTime, Type type, User[] attendees, String bookingId) {
		super();
		this.uID = generateUID();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.attendees = attendees;
		this.bookingId = bookingId;
	}

	public String generateUID() {
		return UUID.randomUUID().toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User[] getAttendees() {
		return attendees;
	}

	public void setAttendees(User[] attendees) {
		this.attendees = attendees;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getuID() {
		return uID;
	}

}