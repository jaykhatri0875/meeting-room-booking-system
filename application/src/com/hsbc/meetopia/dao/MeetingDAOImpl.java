package com.hsbc.meetopia.dao;

/*
	this is meeting DAO layer which implements below methods from meetingDAO interface:
		- createMeeting :-  it stores new scheduled meeting
		- fetchmeetingBYUserID :- fetches meetings of a user from userID
		- fetchMeetingbyMeetingID :- fetch meeting by unique meetingId
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.Booking;
import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.util.DatabaseUtils;

public class MeetingDAOImpl implements MeetingDAO {

	Connection connection = DatabaseUtils.getRemoteConnection();

	private static final String SELECT_FROM_MEETING = "select meeting.uid,meeting.title,booking_info.room_no,booking_info.dateOfBooking,"
			+ "booking_info.start_time,booking_info.end_time,booking_info.booked_by from meeting left join booking_info on "
			+ "meeting.booking_info = booking_info.uid";
	private static final String INSERT_MEETING = "insert into meeting (uid,title,booking_info,typeOfMeeting) values (?,?,?,?)";
	// private static final String INSERT_ATTENDEE = "insert into list_of_people
	// (uid,userid) values(?,?)";
	private static final String SELECT_MEETING_BY_USERID = "SELECT uid from list_of_people where user_uid = ?";
	private static final String SELECT_MEETING_BY_MEETINGID = "select meeting.uid,meeting.title,meeting.typeOfMeeting,booking_info.room_no,"
			+ "booking_info.date,booking_info.start_time,booking_info.end_time,booking_info.booked_by from meeting left join booking_info on "
			+ "meeting.booking_info = booking_info.uid where meeting.uid=?";

	public Meeting createMeeting(Meeting meeting) throws ConnectionFailedException {
		if (connection != null) {
			try {
				// connection.setAutoCommit(false);
				PreparedStatement statement = connection.prepareStatement(INSERT_MEETING);
				statement.setString(1, meeting.getuID());
				statement.setString(2, meeting.getTitle());
				statement.setString(3, meeting.getBooking().getuID());
				statement.setString(4, meeting.getType().toString());

				/*
				 * PreparedStatement preparedStatement =
				 * connection.prepareStatement(INSERT_ATTENDEE); for (User attendee :
				 * meeting.getAttendees()) { preparedStatement.setString(1, meeting.getuID());
				 * preparedStatement.setString(2, attendee.getuID());
				 * preparedStatement.addBatch(); }
				 */

				int recordsUpdated = statement.executeUpdate();
				// int[] rowsUpdated = preparedStatement.executeBatch();
				if (recordsUpdated > 0) {
					// connection.commit();
					return meeting;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While meeting creation");
	}

	public Collection<String> fetchMeetingsByUserId(String userId) throws ConnectionFailedException {
		if (connection != null) {
			List<String> meetings = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_MEETING_BY_USERID);
				statement.setString(1, userId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					meetings.add(rs.getString("uid"));
				}
				return meetings;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by userId");
	}

	public Meeting fetchMeetingByMeetingId(String meetingId) throws ConnectionFailedException {
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_MEETING_BY_MEETINGID);
				statement.setString(1, meetingId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Booking booking = new Booking(rs.getString("uid"), rs.getString("booking_info.room_no"),
							rs.getDate("booking_info.date"), rs.getTime("booking_info.start_time"),
							rs.getTime("booking_info.end_time"), rs.getString("booking_info.booked_by"));
					Meeting meeting = new Meeting(rs.getString("meeting.uid"), rs.getString("meeting.title"),
							rs.getString("meeting.typeOfMeeting"), booking);
					return meeting;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by meetingId");
	}
}
