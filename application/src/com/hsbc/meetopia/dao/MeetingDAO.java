package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.exception.ConnectionFailedException;
import com.hsbc.meetopia.model.Meeting;

public interface MeetingDAO {

	static MeetingDAO getInstance() {
		return new MeetingDAOImpl();
	}

	Meeting createMeeting(Meeting meeting) throws ConnectionFailedException;

	Collection<String> fetchMeetingsByUserId(String userId) throws ConnectionFailedException;

	Meeting fetchMeetingByMeetingId(String meetingId) throws ConnectionFailedException;
}
