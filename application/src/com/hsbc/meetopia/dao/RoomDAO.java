package com.hsbc.meetopia.dao;

import java.util.*;

import com.hsbc.meetopia.model.*;

public interface RoomDAO {
	
	Room createRoom(Room meetingRoom);
	
	Collection<Room> fetchAllRooms();
	
	Room fetchRoomById(String roomId);
	
	Room updateRoom(Room meetingRoom);
	
	static RoomDAO getInstance() {
		return new RoomDAOImpl();
	}
}
