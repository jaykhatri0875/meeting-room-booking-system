package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.Room;

public interface RoomService {

	int createRoom(String meetingId, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall,
			int whiteboard, int waterDispenser, int coffeeMachine);

	Collection<Room> fetchAllRooms();

	Room fetchRoomById(String roomId);
	
	int deleteRoom(String roomId);

	int updateRoom(String meetingId, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall,
			int whiteboard, int waterDispenser, int coffeeMachine);

	static RoomService getInstance() {
		return new RoomServiceImpl();
	}
}
