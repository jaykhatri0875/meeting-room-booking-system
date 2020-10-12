package com.hsbc.meetopia.service;

/*
	room service layer 
	it calls dao layer after doing validations 
*/
import java.util.Collection;
import java.util.UUID;

import com.hsbc.meetopia.dao.RoomDAO;
import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.Amenities;
import com.hsbc.meetopia.model.Room;

public class RoomServiceImpl implements RoomService {

	String meetingRoomName = "MR";
	static int meetingRoomCount = 300;

	RoomDAO dao = RoomDAO.getInstance();

	@Override
	public int createRoom(String meetingName, int capacity, int ratings, int cost, int projector, int wifi, int tv,
			int conCall, int whiteboard, int waterDispenser, int coffeeMachine) {

		String meetingId = meetingRoomName + UUID.randomUUID().toString().replaceAll("[\\s\\-()]", "").substring(0, 5).toUpperCase();
		System.out.println(meetingId);

		Room meetingRoom = new Room(meetingId, capacity, ratings, cost,
				new Amenities(meetingId, projector, wifi, conCall, whiteboard, waterDispenser, tv, coffeeMachine));
		if (this.dao.createRoom(meetingRoom) != null)
			return 1;
		return 0;

	}

	@Override
	public Collection<Room> fetchAllRooms() {
		Collection<Room> rooms = null;
		try {
			rooms = this.dao.fetchAllRooms();
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return rooms;
	}

	@Override
	public int updateRoom(String meetingId, int capacity, int ratings, int cost, int projector, int wifi, int tv,
			int conCall, int whiteboard, int waterDispenser, int coffeeMachine) {

		Room meetingRoom = new Room(meetingId, capacity, ratings, cost,
				new Amenities(meetingId, projector, wifi, conCall, whiteboard, waterDispenser, tv, coffeeMachine));
		System.out.println("Service : " + meetingRoom.toString());
		if (this.dao.updateRoom(meetingRoom) != null)
			return 1;
		return 0;

	}

	@Override
	public Room fetchRoomById(String roomId) {
		Room room = null;
		try {
			room = this.dao.fetchRoomById(roomId);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return room;
	}

	@Override
	public int deleteRoom(String roomId) {
		return this.dao.deleteRoom(roomId);
	}

}
