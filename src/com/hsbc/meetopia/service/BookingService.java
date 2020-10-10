/**
 * @author ClanOctate
 * @purpose DAO layer interface for booking information
 */

package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.model.Booking;

public interface BookingService {
	
	static BookingService getBookingService() {
		return new BookingServiceImpl();
	}
	
	Booking saveBooking(Booking booking);
	
	Booking fetchBookingByUID(String uID) throws BookingNotFoundException;
	
	Collection<Booking> fetchBookings();

}