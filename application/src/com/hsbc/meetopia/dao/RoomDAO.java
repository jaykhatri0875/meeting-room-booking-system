package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.model.Room;

public interface RoomDAO {

	Room createRoom(Room meetingRoom);

	Collection<Room> fetchAllRooms();

	Room fetchRoomById(String roomId);

	Room updateRoom(Room meetingRoom);
	
	int deleteRoom(String roomId);

	static RoomDAO getInstance() {
		return new RoomDAOImpl();
	}
}
