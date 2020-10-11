package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.MeetingRoom;

public interface MeetingRoomService {
	
	int createRoom(String meetingName, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall, int whiteboard, int waterDispender, int coffeeMachine);
	
	Collection<MeetingRoom> fetchAllRooms();
	
	MeetingRoom updateRoom(MeetingRoom meetingRoom);
	
	static MeetingRoomServiceImpl getInstance() {
		return new MeetingRoomServiceImpl();
	}
}
