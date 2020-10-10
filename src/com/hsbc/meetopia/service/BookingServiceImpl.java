/**
 * @author ClanOctate
 * @purpose Service layer implementation for booking information
 */

package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.DAO.BookingDAO;
import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.model.Booking;

public class BookingServiceImpl implements BookingService {

	private BookingDAO dao = BookingDAO.getBookingDAO();
	
	@Override
	public Booking saveBooking(Booking booking) {
		return this.dao.saveBooking(booking);
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