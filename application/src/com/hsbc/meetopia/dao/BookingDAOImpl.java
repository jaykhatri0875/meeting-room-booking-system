package com.hsbc.meetopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.model.Booking;
import com.hsbc.meetopia.util.DatabaseUtils;

public class BookingDAOImpl implements BookingDAO {

	private static final String INSERT_QUERY = "insert into booking_info(uid,room_no,date,start_time,end_time,booked_by) values(?,?,?,?,?,?)";
	private static final String SELECT_QUERY = "select * from booking_info";
	private static final String SELECT_BY_UID_QUERY = "select * from booking_info where uid=?;";

	@Override
	public Booking saveBooking(Booking booking) {
		Connection connection = DatabaseUtils.getRemoteConnection();
		if (connection != null) {
			try (PreparedStatement pStmt = connection.prepareStatement(INSERT_QUERY)) {
				pStmt.setString(1, booking.getuID());
				pStmt.setString(2, booking.getRoomId());
				pStmt.setDate(3, booking.getDate());
				pStmt.setTime(4, booking.getStartTime());
				pStmt.setTime(5, booking.getEndTime());
				pStmt.setString(6, booking.getBookedBy());

				int recordsUpdated = pStmt.executeUpdate();
				if (recordsUpdated > 0) {
					return booking;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Booking not inserted");
		return null;
	}

	@Override
	public Booking fetchBookingByUID(String uID) throws BookingNotFoundException {
		Connection connection = DatabaseUtils.getRemoteConnection();
		try (PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_UID_QUERY)) {
			pStmt.setString(1, uID);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				Booking booking = new Booking(rs.getString("room_no"), rs.getDate("date"), rs.getTime("start_time"),
						rs.getTime("end_time"), rs.getString("booked_by"));
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
		Connection connection = DatabaseUtils.getRemoteConnection();
		Set<Booking> bookingsSet = new HashSet<>();
		try {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_QUERY);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Booking booking = new Booking(rs.getString("room_no"), rs.getDate("date"), rs.getTime("start_time"),
						rs.getTime("end_time"), rs.getString("booked_by"));
				bookingsSet.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookingsSet;
	}

}