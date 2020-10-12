package com.hsbc.meetopia.dao;

/*
	this is DAO layer for meeting rooms
	if implements following methods from roomDAO interface:
		- createRoom :- it inserts room into database table and returns the room object
		- fetchAllrooms :- it fetches all rooms globally from database
		- fetchroomByID: fetches room based on unique meeting room ID 
		- updateRoom :-  updates any changes in room details / amenities and stores in database
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hsbc.meetopia.model.Amenities;
import com.hsbc.meetopia.model.Room;
import com.hsbc.meetopia.util.DatabaseUtils;

public class RoomDAOImpl implements RoomDAO {

	Connection connection = DatabaseUtils.getRemoteConnection();

	private final static String INSERT_INTO_MEETINGROOM = "insert into meeting_room (uid, capacity, rating, perhour_cost) values(?, ?, ?, ?)";
	private final static String INSERT_INTO_AMENITIES = "insert into amenities(uid, projector, wifiConnection, conferenceCallFacility, whiteboard, waterDispenser, tv, coffeeMachine) values (?, ?, ?, ?, ?, ?, ?, ?)";

	private final static String SELECT_FROM_MEETINGROOM = "select * from meeting_room";
	private final static String SELECT_FROM_AMENITIES = "select * from amenities";

	private final static String SELECT_MEETINGRROM_BY_ID = "select * from meeting_room where uid = ?";
	private final static String SELECT_AMENITIES_BY_ID = "select * from amenities where uid = ?";

	private final static String UPDATE_MEETINGROOM = "update meeting_room set capacity = ?, rating = ?, perhour_cost = ? where uid = ?";
	private final static String UPDATE_AMENITIES = "update amenities set projector = ?, wifiConnection = ?, conferenceCallFacility = ?, whiteboard = ?, waterDispenser = ?, tv = ?, coffeeMachine = ? where uid = ?";
	
	private final static String DELETE_AMENITIES = "delete from amenities where uid = ?";
	private final static String DELETE_MEETINGROOM = "delete from meeting_room where uid = ?";

	@Override
	public Room createRoom(Room meetingRoom) {

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
	public Collection<Room> fetchAllRooms() {
		List<Room> meetingRooms = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_FROM_MEETINGROOM);
			PreparedStatement statement2 = connection.prepareStatement(SELECT_FROM_AMENITIES);

			ResultSet rs1 = statement2.executeQuery();

			List<Amenities> amenities = new ArrayList<>();

			while (rs1.next()) {
				amenities.add(new Amenities(rs1.getString("uid"), rs1.getInt("projector"), rs1.getInt("wifiConnection"),
						rs1.getInt("conferenceCallFacility"), rs1.getInt("whiteboard"), rs1.getInt("waterDispenser"),
						rs1.getInt("tv"), rs1.getInt("coffeeMachine")));

			}
			int count = 0;
			ResultSet rs = statement.executeQuery();
			while (rs.next() && count < amenities.size()) {
				meetingRooms.add(new Room(rs.getString("uid"), rs.getInt("capacity"), rs.getInt("rating"),
						rs.getInt("perhour_cost"), amenities.get(count++)));
			}

			rs.close();
			rs1.close();
			return meetingRooms;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Room updateRoom(Room meetingRoom) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MEETINGROOM);
			preparedStatement.setInt(1, meetingRoom.getSeatingCapacity());
			preparedStatement.setInt(2, meetingRoom.getRatings());
			preparedStatement.setInt(3, meetingRoom.getCostPerHour());
			preparedStatement.setString(4, meetingRoom.getuId());

			int rowsUpdated = preparedStatement.executeUpdate();

			PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE_AMENITIES);
			preparedStatement1.setInt(1, meetingRoom.getAmenities().isProjector());
			preparedStatement1.setInt(2, meetingRoom.getAmenities().isWifiConnection());
			preparedStatement1.setInt(3, meetingRoom.getAmenities().isConferenceCallFacility());
			preparedStatement1.setInt(4, meetingRoom.getAmenities().isWhiteboard());
			preparedStatement1.setInt(5, meetingRoom.getAmenities().isWaterDispenser());
			preparedStatement1.setInt(6, meetingRoom.getAmenities().isTv());
			preparedStatement1.setInt(7, meetingRoom.getAmenities().isCoffeeMachine());
			preparedStatement1.setString(8, meetingRoom.getuId());

			int rowsUpdated1 = preparedStatement1.executeUpdate();

			System.out.println("In Dao : " + rowsUpdated + ", " + rowsUpdated1);

			if (rowsUpdated > 0 && rowsUpdated1 > 0) {
				return meetingRoom;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Room fetchRoomById(String roomId) {
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_MEETINGRROM_BY_ID);
			statement.setString(1, roomId);

			PreparedStatement statement2 = connection.prepareStatement(SELECT_AMENITIES_BY_ID);
			statement2.setString(1, roomId);

			ResultSet rs1 = statement2.executeQuery();

			Amenities amenities = null;
			Room meetingRoom = null;

			if (rs1.next()) {
				amenities = new Amenities(rs1.getString("uid"), rs1.getInt("projector"), rs1.getInt("wifiConnection"),
						rs1.getInt("conferenceCallFacility"), rs1.getInt("whiteboard"), rs1.getInt("waterDispenser"),
						rs1.getInt("tv"), rs1.getInt("coffeeMachine"));

			}
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				meetingRoom = new Room(rs.getString("uid"), rs.getInt("capacity"), rs.getInt("rating"),
						rs.getInt("perhour_cost"), amenities);
			}

			rs.close();
			rs1.close();

			return meetingRoom;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int deleteRoom(String roomId) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AMENITIES);
			PreparedStatement preparedStatement1 = connection.prepareStatement(DELETE_MEETINGROOM);
			
			preparedStatement.setString(1, roomId);
			int deleteUpdate = preparedStatement.executeUpdate();
			
			preparedStatement1.setString(1, roomId);
			int deleteUpdate1 = preparedStatement1.executeUpdate();
			
			if(deleteUpdate > 0)
				System.out.println("amenitity deleted");
			if(deleteUpdate1 > 0)
				System.out.println("meeting deleted");
			
			if(deleteUpdate > 0 && deleteUpdate1 > 0) {
				System.out.println("Deleted");
				return 1;
			}else
				System.out.println("not deleted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
