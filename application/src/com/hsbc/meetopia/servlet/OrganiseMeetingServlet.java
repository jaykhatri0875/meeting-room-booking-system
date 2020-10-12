package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meetopia.model.Booking;
import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.model.Room;
import com.hsbc.meetopia.model.User;
import com.hsbc.meetopia.service.BookingService;
import com.hsbc.meetopia.service.MeetingService;
import com.hsbc.meetopia.service.RoomService;

public class OrganiseMeetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		String bookedBy = user.getuID();

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

		Booking booking = new Booking(roomId, meetingDate, startTime, endTime, bookedBy);
		Meeting meeting = new Meeting(title, type, booking);

		BookingService bookingService = BookingService.getInstance();
		bookingService.saveBooking(booking);

		MeetingService meetingService = MeetingService.getInstance();
		Meeting meetingCreated = meetingService.saveMeeting(meeting);

		if (meetingCreated != null) {
			response.sendRedirect("ManagerPage");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("organiseMeeting.jsp").include(request, response);

		RoomService roomService = RoomService.getInstance();
		Collection<Room> rooms = roomService.fetchAllRooms();
		List<String> roomIds = new ArrayList<>();
		for (Room room : rooms) {
			roomIds.add(room.getuId());
		}
		request.setAttribute("rooms", roomIds);
	}
}
