package com.hsbc.meetopia.model;

import java.util.UUID;

public class Meeting {

	private final String uID;
	private String title;
	private MeetingType type;
	private User[] attendees;
	private Booking booking;

	public Meeting(String title, MeetingType type, User[] attendees, Booking booking) {
		super();
		this.uID = generateUID();
		this.title = title;
		this.type = type;
		this.attendees = attendees;
		this.booking = booking;
	}

	public Meeting(String uID, String title, Booking booking) {
		super();
		this.uID = uID;
		this.title = title;
		this.booking = booking;
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

	public MeetingType getType() {
		return type;
	}

	public void setType(MeetingType type) {
		this.type = type;
	}

	public User[] getAttendees() {
		return attendees;
	}

	public void setAttendees(User[] attendees) {
		this.attendees = attendees;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getuID() {
		return uID;
	}

}