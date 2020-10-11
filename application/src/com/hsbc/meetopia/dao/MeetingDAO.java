package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.model.Meeting;

public interface MeetingDAO {

	static MeetingDAO getInstance() {
		return new MeetingDAOImpl();
	}

	Meeting createMeeting(Meeting meeting);

	Collection<String> fetchMeetingsByUserId(String userId);

	Meeting fetchMeetingByMeetingId(String meetingId);
}
