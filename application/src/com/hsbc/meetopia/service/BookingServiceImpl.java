package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.dao.BookingDAO;
import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.Booking;

public class BookingServiceImpl implements BookingService {

	private BookingDAO dao = BookingDAO.getInstance();

	@Override
	public Booking saveBooking(Booking booking) {
		Booking booking1 = null;
		try {
			booking1 = this.dao.saveBooking(booking);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return booking1;
	}

	@Override
	public Booking fetchBookingByUID(String uID) throws BookingNotFoundException {
		return this.dao.fetchBookingByUID(uID);
	}

	@Override
	public Collection<Booking> fetchBookings() {
		return this.dao.fetchBookings();
	}

}