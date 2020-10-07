package com.hsbc.meetopia.service;

import java.util.Collection;

import com.hsbc.meetopia.dao.MeetingDAO;
import com.hsbc.meetopia.model.Meeting;

public class MeetingService {

	private MeetingDAO meetingDAO = new MeetingDAO();

	public Meeting saveMeeting(Meeting Meeting) {
		return this.meetingDAO.createMeeting(Meeting);
	}

	public Collection<Meeting> fetchMeetings() {
		return this.meetingDAO.fetchMeetings();
	}

	public Meeting fetchMeetingByMeetingId(String meetingId) {
		return meetingDAO.fetchMeetingByUID(meetingId);
	}

	public Meeting updateMeeting(String meetingId, Meeting meeting) {
		return meetingDAO.updateMeeting(meetingId, meeting);
	}

}
