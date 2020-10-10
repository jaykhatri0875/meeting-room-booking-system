package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.MeetingRoom;

public class MeetingRoomServiceImpl implements MeetingRoomService{
	
	String meetingName = "MR";
	static int meetingRoomCount = 100;
	
	@Override
	public MeetingRoom createRoom(String meetingName, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall, int whiteboard, int waterDispender, int coffeeMachine) {
		
		return null;
	}

	@Override
	public Collection<MeetingRoom> fetchAllRooms() {
		return null;
	}

	@Override
	public MeetingRoom updateRoom(MeetingRoom meetingRoom) {
		return null;
	}

}
