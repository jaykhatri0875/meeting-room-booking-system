package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.model.Meeting;

public interface MeetingService {

	static MeetingService getInstance() {
		return new MeetingServiceImpl();
	}

	Meeting saveMeeting(Meeting Meeting);

	Meeting fetchMeetingByMeetingId(String meetingId);

	Collection<Meeting> fetchMeetingsByUserId(String userId);

}
