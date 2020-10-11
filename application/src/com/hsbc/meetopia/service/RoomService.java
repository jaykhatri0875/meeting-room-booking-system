package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.Room;

public interface RoomService {
	
	int createRoom(String meetingName, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall, int whiteboard, int waterDispender, int coffeeMachine);
	
	Collection<Room> fetchAllRooms();
	
	Room updateRoom(Room meetingRoom);
	
	static RoomServiceImpl getInstance() {
		return new RoomServiceImpl();
	}
}
