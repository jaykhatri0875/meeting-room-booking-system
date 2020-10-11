package com.hsbc.meetopia.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hsbc.meetopia.dao.MeetingDAO;
import com.hsbc.meetopia.model.Meeting;

public class MeetingServiceImpl implements MeetingService {

	private MeetingDAO dao = MeetingDAO.getInstance();

	public Meeting saveMeeting(Meeting Meeting) {
		return this.dao.createMeeting(Meeting);
	}

	public Meeting fetchMeetingByMeetingId(String meetingId) {
		return this.dao.fetchMeetingByMeetingId(meetingId);
	}

	public Collection<Meeting> fetchMeetingsByUserId(String userId) {
		List<Meeting> meetings = new ArrayList<>();
		Collection<String> meetingIds = this.dao.fetchMeetingsByUserId(userId);
		for (String meetingId : meetingIds) {
			Meeting meeting = fetchMeetingByMeetingId(meetingId);
			meetings.add(meeting);
		}
		return meetings;
	}

}
