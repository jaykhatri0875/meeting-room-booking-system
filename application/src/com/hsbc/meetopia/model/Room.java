package com.hsbc.meetopia.model;

public class Room {
	
	private String uId;
	
	private String userId;
	
	private int seatingCapacity;
	
	private int ratings;
	
	private int costPerHour;
	
	private Amenities amenities;
	
	public Room(String uId, int seatingCapacity, int ratings, int costPerHour, Amenities amenities) {
		
		this.uId = uId;
		this.seatingCapacity = seatingCapacity;
		this.ratings = ratings;
		this.costPerHour = costPerHour;
		this.amenities = amenities;
	}
	/*
	 * public MeetingRoom(String meetingName, int seatingCapacity, int ratings, int
	 * costPerHour, Amenities amenities) {
	 * 
	 * this.meetingName = meetingName; this.seatingCapacity = seatingCapacity;
	 * this.ratings = ratings; this.costPerHour = costPerHour; this.amenities =
	 * amenities; }
	 */
	
	/*
	 * public MeetingRoom(String meetingName, int seatingCapacity, int costPerHour,
	 * Amenities amenities) {
	 * 
	 * this.meetingName = meetingName; this.seatingCapacity = seatingCapacity;
	 * this.costPerHour = costPerHour; this.amenities = amenities; }
	 */


	
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	public int getRatings() {
		return ratings;
	}
	
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	public int getCostPerHour() {
		return costPerHour;
	}
	
	public void setCostPerHour(int costPerHour) {
		this.costPerHour = costPerHour;
	}
	
	public Amenities getAmenities() {
		return amenities;
	}
	
	public void setAmenities(Amenities amenities) {
		this.amenities = amenities;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getUserId() {
		return userId;
	}

	

	@Override
	public String toString() {
		return "MeetingRoom [uId=" + uId + ", userId=" + userId + ", seatingCapacity="
				+ seatingCapacity + ", ratings=" + ratings + ", costPerHour=" + costPerHour + ", amenities=" + amenities
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costPerHour);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ratings;
		result = prime * result + seatingCapacity;
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
		Room other = (Room) obj;
		if (Double.doubleToLongBits(costPerHour) != Double.doubleToLongBits(other.costPerHour))
			return false;
		if (ratings != other.ratings)
			return false;
		if (seatingCapacity != other.seatingCapacity)
			return false;
		return true;
	}
	
	

	
	
}