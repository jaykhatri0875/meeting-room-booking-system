package com.hsbc.meetopia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hsbc.meetopia.model.*;
import com.hsbc.meetopia.util.DatabaseConnection;
import com.hsbc.meetopia.util.DatabaseUtils;

public class MeetinRoomDAOImpl implements MeetingRoomDAO {

	Connection connection = DatabaseUtils.getRemoteConnection();

	private final static String INSERT_INTO_MEETINGROOM = "insert into meeting_room (uid, capacity, rating, perhour_cost) values(?, ?, ?, ?)";
	private final static String INSERT_INTO_AMENITIES = "insert into amenities(uid, projector, wifiConnection, conferenceCallFacility, whiteboard, waterDispenser, tv, coffeeMachine) values (?, ?, ?, ?, ?, ?, ?, ?)";

	private final static String SELECT_FROM_MEETINGROOM = "select * from meeting_room";
	private final static String SELECT_FROM_AMENITIES = "select * from amenities";

	private final static String UPDATE_MEETINGROOM = "update meeting_room set capacity = ?, rating = ?, perhour_cost = ? where uid = ?";
	private final static String UPDATE_AMENITIES = "update amenities set projector = ?, wifiConnection = ?, conferenceCallFacility = ?, whiteboard = ?, waterDispenser = ?, tv = ?, coffeeMachine = ? where uid = ?";

	@Override
	public MeetingRoom createRoom(MeetingRoom meetingRoom) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_MEETINGROOM);
			preparedStatement.setString(1, meetingRoom.getuId());
			preparedStatement.setInt(2, meetingRoom.getSeatingCapacity());
			preparedStatement.setInt(3, meetingRoom.getRatings());
			preparedStatement.setInt(4, meetingRoom.getCostPerHour());

			int rowsUpdated = preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(INSERT_INTO_AMENITIES);
			preparedStatement.setString(1, meetingRoom.getAmenities().getUid());
			preparedStatement.setInt(2, meetingRoom.getAmenities().isProjector());
			preparedStatement.setInt(3, meetingRoom.getAmenities().isWifiConnection());
			preparedStatement.setInt(4, meetingRoom.getAmenities().isConferenceCallFacility());
			preparedStatement.setInt(5, meetingRoom.getAmenities().isWhiteboard());
			preparedStatement.setInt(6, meetingRoom.getAmenities().isWaterDispenser());
			preparedStatement.setInt(7, meetingRoom.getAmenities().isTv());
			preparedStatement.setInt(8, meetingRoom.getAmenities().isCoffeeMachine());

			int rowsUpdated1 = preparedStatement.executeUpdate();

			if (rowsUpdated > 0 && rowsUpdated1 > 0)
				return meetingRoom;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Collection<MeetingRoom> fetchAllRooms() {
		List<MeetingRoom> meetingRooms = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(SELECT_FROM_MEETINGROOM);
			ResultSet rs1 = statement.executeQuery(SELECT_FROM_AMENITIES);

			while (rs.next() && rs1.next()) {
				Amenities amenities = new Amenities(rs1.getString("uid"),rs1.getInt("projector"), rs1.getInt("wifiConnection"), rs1.getInt("conferenceCallFacility"),
						rs1.getInt("whiteboard"), rs1.getInt("waterDispenser"), rs1.getInt("tv"),
						rs1.getInt("coffeeMachine"));
				meetingRooms.add(new MeetingRoom(rs.getString("uid"), rs.getInt("capacity"),
						rs.getInt("rating"), rs.getInt("perhour_cost"), amenities));
			}

			return meetingRooms;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MeetingRoom updateRoom(MeetingRoom meetingRoom) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_MEETINGROOM);
			preparedStatement.setInt(1, meetingRoom.getSeatingCapacity());
			preparedStatement.setInt(2, meetingRoom.getRatings());
			preparedStatement.setInt(3, meetingRoom.getCostPerHour());

			int rowsUpdated = preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(UPDATE_AMENITIES);
			preparedStatement.setInt(1, meetingRoom.getAmenities().isProjector());
			preparedStatement.setInt(2, meetingRoom.getAmenities().isWifiConnection());
			preparedStatement.setInt(3, meetingRoom.getAmenities().isConferenceCallFacility());
			preparedStatement.setInt(4, meetingRoom.getAmenities().isWhiteboard());
			preparedStatement.setInt(5, meetingRoom.getAmenities().isWaterDispenser());
			preparedStatement.setInt(6, meetingRoom.getAmenities().isTv());
			preparedStatement.setInt(7, meetingRoom.getAmenities().isCoffeeMachine());

			int rowsUpdated1 = preparedStatement.executeUpdate();

			if (rowsUpdated > 0 && rowsUpdated1 > 0) {
				return meetingRoom;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
