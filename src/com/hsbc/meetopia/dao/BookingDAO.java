/**
 * @author ClanOctate
 * @purpose DAO layer interface for booking information
 */

package com.hsbc.meetopia.DAO;

import java.util.Collection;

import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.model.Booking;

public interface BookingDAO {
	
	static BookingDAOImpl getBookingDAO() {
		return new BookingDAOImpl();
	}
	
	Booking saveBooking(Booking booking);
	
	Booking fetchBookingByUID(String uID) throws BookingNotFoundException;
	
	Collection<Booking> fetchBookings();

}