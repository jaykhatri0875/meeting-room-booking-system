package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.Booking;

public interface BookingDAO {

	static BookingDAOImpl getInstance() {
		return new BookingDAOImpl();
	}

	Booking saveBooking(Booking booking) throws ConnectionFailedException;

	Booking fetchBookingByUID(String uID) throws BookingNotFoundException;

	Collection<Booking> fetchBookings();

}