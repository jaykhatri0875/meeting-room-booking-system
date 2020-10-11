package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meetopia.model.Meeting;
import com.hsbc.meetopia.model.User;
import com.hsbc.meetopia.service.MeetingService;

public class MemberPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");

		MeetingService meetingService = MeetingService.getInstance();
		Collection<Meeting> meetings = meetingService.fetchMeetingsByUserId(user.getuID());

		req.setAttribute("meetings", meetings);
		req.setAttribute("user", user);

		RequestDispatcher rd = req.getRequestDispatcher("member.jsp");
		rd.forward(req, res);
	}
}
