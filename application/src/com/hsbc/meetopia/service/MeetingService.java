package com.hsbc.meetopia.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hsbc.meetopia.dao.MeetingDAO;
import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.model.User;

public class MeetingService {

	private MeetingDAO meetingDAO = new MeetingDAO();

	public Meeting saveMeeting(Meeting Meeting) {
		return this.meetingDAO.createMeeting(Meeting);
	}

	public Collection<Meeting> fetchMeetings() {
		return this.meetingDAO.fetchMeetings();
	}

	public Meeting fetchMeetingByMeetingId(String meetingId) {
		return meetingDAO.fetchMeetingByMeetingId(meetingId);
	}

	public Collection<Meeting> fetchMeetingsByUserId(String userId) {
		List<Meeting> meetings = new ArrayList<>();
		Collection<String> meetingIds = this.meetingDAO.fetchMeetingsByUserId(userId);
		for (String meetingId : meetingIds) {
			Meeting meeting = fetchMeetingByMeetingId(meetingId);
			meetings.add(meeting);
		}
		return meetings;
	}
	
	public User fetchUserfromId(String userId) {
		
		
		return this.meetingDAO.fetchUserfromId(userId);
		
	}

}
