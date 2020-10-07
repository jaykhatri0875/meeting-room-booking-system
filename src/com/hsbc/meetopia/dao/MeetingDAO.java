package com.hsbc.meetopia.dao;

import java.util.Collection;

import com.hsbc.meetopia.model.Meeting;

public class MeetingDAO {

	public Meeting createMeeting(Meeting meeting) {
		return meeting;
	}

	public Collection<Meeting> fetchMeetings() {
		return null;
	}

	public Meeting fetchMeetingByUID(String uID) {
		return null;
	}

	public Meeting updateMeeting(String uID, Meeting meeting) {
		return meeting;
	}

}
