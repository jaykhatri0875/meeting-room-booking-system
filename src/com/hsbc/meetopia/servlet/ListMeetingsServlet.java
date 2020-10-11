package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.service.MeetingService;

public class ListMeetingsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		System.out.println(userId);

		MeetingService meetingService = new MeetingService();
		Collection<Meeting> meetings = meetingService.fetchMeetingsByUserId(userId);

		req.setAttribute("meetings", meetings);
		
		RequestDispatcher rd = req.getRequestDispatcher("manager-page.jsp"); 
		rd.forward(req, res);
		
		
		PrintWriter pw = res.getWriter();
		pw.write("<h1>List of meetings: </h1><br>");

		pw.write("<table>");
		pw.write("<tr>");
		pw.write("<th>Meeting Name</th><th>Meeting Room</th><th>Start Date</th><th>Time</th><th>Duration</th>");
		pw.write("</tr>");

		for (Meeting meeting : meetings) {
			long duration = meeting.getBooking().getEndTime().getTime() - meeting.getBooking().getStartTime().getTime();
			pw.write("<tr>");
			pw.write("<td>" + meeting.getTitle() + "</td>");
			pw.write("<td>" + meeting.getBooking().getRoomId() + "</td>");
			pw.write("<td>" + meeting.getBooking().getDate() + "</td>");
			pw.write("<td>" + meeting.getBooking().getStartTime() + "</td>");
			pw.write("<td>" + (duration / (1000 * 60 * 60)) % 24 + "</td>");
			pw.write("</tr>");
		}
		pw.write("</table>");

	}
}
