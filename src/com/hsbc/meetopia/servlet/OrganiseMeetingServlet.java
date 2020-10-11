package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meetopia.model.Booking;
import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.service.BookingService;
import com.hsbc.meetopia.service.MeetingService;

public class OrganiseMeetingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = "UI18912"; // To be fetched from the session

		String title = request.getParameter("meetingName");
		Date meetingDate = Date.valueOf(request.getParameter("meetingDate"));

		String meetingTime = request.getParameter("meetingTime");
		LocalTime localTime = LocalTime.parse(meetingTime);
		Time startTime = Time.valueOf(localTime);

		int durationHrs = Integer.parseInt(request.getParameter("durationHrs"));
		int durationMin = Integer.parseInt(request.getParameter("durationMin"));
		String roomId = request.getParameter("meetingRoom");
		String type = request.getParameter("meetingType");

		Date addedTime = new Date(startTime.getTime() + (durationHrs * 60 * 60 * 1000) + (durationMin * 60 * 1000));
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		Time endTime = Time.valueOf(localDateFormat.format(addedTime));

		String bookedBy = userId;

		Booking booking = new Booking(roomId, meetingDate, startTime, endTime, bookedBy);
		Meeting meeting = new Meeting(title, type, booking);

		BookingService bookingService = BookingService.getBookingService();
		bookingService.saveBooking(booking);

		MeetingService meetingService = new MeetingService();
		meetingService.saveMeeting(meeting);

		response.sendRedirect("listMeetings?userId=" + userId);
	}
}
