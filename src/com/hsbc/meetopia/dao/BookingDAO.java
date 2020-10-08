package com.hsbc.meetopia.dao;

import com.hsbc.meetopia.model.Booking;

public interface BookingDAO {
	
	static BookingDAOImpl getInstance() {
		return new BookingDAOImpl();
	}
	
	Booking saveBooking(Booking booking);
	
	

}
