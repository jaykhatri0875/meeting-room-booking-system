/**
 * @author ClanOctate
 * @purpose DAO layer implementation for booking information
 */

package com.hsbc.meetopia.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.hsbc.meetopia.exception.BookingNotFoundException;
import com.hsbc.meetopia.model.Booking;
import com.hsbc.meetopia.util.DatabaseConnection;

public class BookingDAOImpl implements BookingDAO {
	
	Connection connection = DatabaseConnection.getConnection();

	private static final String INSERT_QUERY = "insert into booking_info(uid,room_no,dateOfBooking,start_time,end_time,booked_by)"
			+ " values('?','?','?','?','?','?')";

	private static final String SELECT_QUERY = "select * from booking_info";

	private static final String SELECT_BY_UID_QUERY = "select * from booking_info where uid=?;";

	@Override
	public Booking saveBooking(Booking booking) {

		int numberOfRecordsUpdated = 0;

		try (PreparedStatement pStmt = connection.prepareStatement(INSERT_QUERY);) {

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

		if (numberOfRecordsUpdated > 0) {
			return booking;
		}
		return null;
	}

	@Override
	public Booking fetchBookingByUID(String uID) throws BookingNotFoundException {

		try (PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_UID_QUERY);) {

			pStmt.setString(1, uID);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {

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

		try (PreparedStatement pStmt = connection.prepareStatement(SELECT_QUERY);) {

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

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