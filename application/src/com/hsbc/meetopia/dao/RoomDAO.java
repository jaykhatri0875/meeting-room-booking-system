package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.Room;

public interface RoomDAO {

	Room createRoom(Room meetingRoom);

	Collection<Room> fetchAllRooms() throws ConnectionFailedException;

	Room fetchRoomById(String roomId) throws ConnectionFailedException;

	Room updateRoom(Room meetingRoom);

	static RoomDAO getInstance() {
		return new RoomDAOImpl();
	}

	int deleteRoom(String roomId);
}
