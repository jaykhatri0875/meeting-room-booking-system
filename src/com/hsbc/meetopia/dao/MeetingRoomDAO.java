package com.hsbc.meetopia.dao;

import java.util.*;

import com.hsbc.meetopia.model.*;

public interface MeetingRoomDAO {
	
	MeetingRoom createRoom(MeetingRoom meetingRoom);
	
	Collection<MeetingRoom> fetchAllRooms();
	
	MeetingRoom updateRoom(MeetingRoom meetingRoom);
	
	static MeetinRoomDAOImpl getInstance() {
		return new MeetinRoomDAOImpl();
	}
}
