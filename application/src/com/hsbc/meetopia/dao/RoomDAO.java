package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.model.Room;

public interface RoomDAO {

	Room createRoom(Room meetingRoom);

	Collection<Room> fetchAllRooms();

	Room updateRoom(Room meetingRoom);

	static RoomDAO getInstance() {
		return new RoomDAOImpl();
	}
}
