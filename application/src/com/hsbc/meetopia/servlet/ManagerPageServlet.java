package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.service.MeetingService;

public class ManagerPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userId = req.getParameter("userId"); // to be fetched from the session
		MeetingService meetingService = MeetingService.getInstance();
		Collection<Meeting> meetings = meetingService.fetchMeetingsByUserId(userId);
		// User user = meetingService.fetchUserfromId(userId);

		req.setAttribute("meetings", meetings);
		// req.setAttribute("user", user);

		RequestDispatcher rd = req.getRequestDispatcher("manager-page.jsp");
		rd.forward(req, res);
	}
}
