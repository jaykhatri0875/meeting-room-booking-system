/**
 * @author ClanOctate
 * @purpose Exception for booking information
 */

package com.hsbc.meetopia.exception;

public class BookingNotFoundException extends Exception {

	public BookingNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}	
	
}