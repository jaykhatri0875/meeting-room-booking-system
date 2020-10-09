package com.hsbc.meetopia.model;

import java.time.LocalDate;
import java.util.UUID;

public class Booking {
	
	private final String uID;
	private String roomId;
	private LocalDate bookingDate;
	private long startTime; // in milliseconds (with in-built bookingDate)
	private long endTime; // can be easily converted to any bookingDate format
	private String bookedBy;

	public Booking(String roomId, LocalDate bookingDate, long startTime, long endTime, String bookedBy) {
		super();
		this.uID = generateUID();
		this.roomId = roomId;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookedBy = bookedBy;
	}
	
	public Booking(String uID, String roomId, long startTime, long endTime, String bookedBy) {
		super();
		this.uID = uID;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookedBy = bookedBy;
	}


	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public LocalDate getDate() {
		return bookingDate;
	}

	public void setDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	public String getuID() {
		return uID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uID == null) ? 0 : uID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (uID == null) {
			if (other.uID != null)
				return false;
		} else if (!uID.equals(other.uID))
			return false;
		return true;
	}

	public String generateUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String toString() {
		return "Booking [uID=" + uID + ", roomId=" + roomId + ", bookingDate=" + bookingDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", bookedBy=" + bookedBy + "]";
	}

}