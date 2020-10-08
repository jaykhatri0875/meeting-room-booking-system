/**
 * @author ClanOctate
 * @purpose DAO layer implementation for booking information
 */

package com.hsbc.meetopia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.model.Booking;


public class BookingDAOImpl implements BookingDAO {
	
	private static String DB_URL = "jdbc:mysql://db4free.net:3306/codefury";
	private static String username = "codefury"; 
	private static String password = "codefury"; 

	
	private static final String INSERT_QUERY = "insert into booking_info(uid,room_no,dateOfBooking,start_time,end_time,booked_by)"
			+ " values('?','?','?','?','?','?')";

	private static final String SELECT_QUERY = "select * from booking_info";
	
	private static final String SELECT_BY_UID_QUERY = "select * from booking_info where uid=?;";	

		
	private static Connection getDBConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection(DB_URL, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public boolean saveBooking( Booking booking ) {
		
		int numberOfRecordsUpdated = 0;
		
		try (PreparedStatement pStmt = getDBConnection().prepareStatement(INSERT_QUERY);) {
			
			pStmt.setString(1, booking.getuID());
			pStmt.setString(2, booking.getRoomId());
			pStmt.setDate(3, Date.valueOf(booking.getDate()));
			pStmt.setLong(4, booking.getStartTime());
			pStmt.setLong(5, booking.getEndTime());
			pStmt.setString(2, booking.getRoomId());
			
			numberOfRecordsUpdated = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (numberOfRecordsUpdated == 1) {
			return true;	
		}
		return false;
	}

	
	@Override
	public Booking fetchBookingByUID(String uID) throws BookingNotFoundException {
		
		try(PreparedStatement pStmt = getDBConnection().prepareStatement(SELECT_BY_UID_QUERY);) {
			
			pStmt.setString(1, uID);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {

				Booking booking = new Booking(rs.getString("room_no"), rs.getDate("dateOfBooking").toLocalDate(),
						rs.getLong("start_time"), rs.getLong("end_time"), rs.getString("booked_by"));
				return booking;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookingNotFoundException("Booking with ID " + uID + " does not exist.");
		}
		return null;
	}
	
	@Override
	public Collection<Booking> fetchBookings() {
		
		Set<Booking> bookingsSet = new HashSet<>();
		
		try (PreparedStatement pStmt = getDBConnection().prepareStatement(SELECT_QUERY);){
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				
				Booking booking = new Booking(rs.getString("room_no"), rs.getDate("dateOfBooking").toLocalDate(),
						rs.getLong("start_time"), rs.getLong("end_time"), rs.getString("booked_by"));
				bookingsSet.add(booking);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookingsSet;
	}
	
}