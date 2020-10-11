package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.dao.RoomDAO;
import com.hsbc.meetopia.model.Amenities;
import com.hsbc.meetopia.model.Room;

public class RoomServiceImpl implements RoomService{
	
	String meetingRoomName = "MR";
	static int meetingRoomCount = 300;
	
	RoomDAO dao = RoomDAO.getInstance();
	
	@Override
	public int createRoom(String meetingName, int capacity, int ratings, int cost, int projector, int wifi, int tv, int conCall, int whiteboard, int waterDispenser, int coffeeMachine) {
		
		
		String meetingId = meetingRoomName + Integer.toString(++ meetingRoomCount);
		System.out.println(meetingId);
		
		Room meetingRoom = new Room(meetingId, meetingName, capacity, ratings, cost, new Amenities(meetingId, projector, wifi, conCall, whiteboard, waterDispenser, tv, coffeeMachine)); 
		if(this.dao.createRoom(meetingRoom)!=null)
			return 1;
		return 0;
		
	}

	@Override
	public Collection<Room> fetchAllRooms() {
		return null;
	}

	@Override
	public Room updateRoom(Room meetingRoom) {
		return null;
	}

}
