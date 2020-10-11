package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.dao.MeetingRoomDAO;
import com.hsbc.meetopia.model.Amenities;
import com.hsbc.meetopia.model.MeetingRoom;

public class MeetingRoomServiceImpl implements MeetingRoomService{
	
	String meetingRoomName = "MR";
	static int meetingRoomCount = 200;
	
	MeetingRoomDAO dao = MeetingRoomDAO.getInstance();
	
	@Override
	public int createRoom(String meetingName, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall, int whiteboard, int waterDispenser, int coffeeMachine) {
		
		
		String meetingId = meetingRoomName + Integer.toString(++ meetingRoomCount);
		System.out.println(meetingId);
		
		MeetingRoom meetingRoom = new MeetingRoom(meetingId, meetingName, capacity, ratings, cost, new Amenities(meetingId, projector, wifi, conCall, whiteboard, waterDispenser, tv, coffeeMachine)); 
		if(this.dao.createRoom(meetingRoom)!=null)
			return 1;
		return 0;
		
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
