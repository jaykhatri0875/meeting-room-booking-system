package com.hsbc.meetopia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;

import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.model.User;

public class MeetingDAO {

	private static final String SELECT_QUERY = "select * from meeting";
	private static final String INSERT_MEETING = "insert into meeting (uid,title,booking_info,typeOfMeeting) values (?,?,?,?)";
	private static final String INSERT_ATTENDEE = "insert into list_of_people (uid,userid) values(?,?)";
	private static final String SELECT_BY_MEETING_UID = "select * from meetings where uid=?";

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://db4free.net:3306/codefury";
	public static final String USER = "codefury";
	public static final String PASS = "codefury";

	static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Meeting createMeeting(Meeting meeting) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(INSERT_MEETING);
			preparedStatement.setString(1, meeting.getuID());
			preparedStatement.setString(2, meeting.getTitle());
			preparedStatement.setString(3, meeting.getBooking().getuID());
			preparedStatement.setString(4, meeting.getType().toString());

			PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_ATTENDEE);
			for (User attendee : meeting.getAttendees()) {
				preparedStatement1.setString(1, meeting.getuID());
				preparedStatement1.setString(2, attendee.getuID());
				preparedStatement.addBatch();
			}

			int[] rowsUpdated = preparedStatement.executeBatch();
			if (rowsUpdated.length > 0) {
				connection.commit();
				return meeting;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Meeting not inserted");
		return null;
	}

	public Collection<Meeting> fetchMeetings() {
		return null;
	}

	public Meeting fetchMeetingByUID(String uID) {
		return null;
	}

	public Meeting updateMeeting(String uID, Meeting meeting) {
		return meeting;
	}

}
