package com.hsbc.meetopia.DAO;

import java.sql.Connection;
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