package com.hsbc.meetopia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meetopia.service.MeetingRoomService;

/**
 * Servlet implementation class CreateRoomServlet
 */
@WebServlet("/CreateRoomServlet")
public class CreateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String meetingName = req.getParameter("meetingName");
		int capacity = Integer.parseInt(req.getParameter("capacity"));
		int ratings = Integer.parseInt(req.getParameter("ratings"));
		int cost = Integer.parseInt(req.getParameter("cost"));
		
		int projector = req.getParameter("projector") != null ? 1 :0;
		int wifi = req.getParameter("wifi") != null ? 1 :0;
		int tv = req.getParameter("tv") != null ? 1 :0;
		int conCall = req.getParameter("conCall") != null ? 1 :0;
		int whiteboard = req.getParameter("whiteboard") != null ? 1 :0;
		int waterDispender = req.getParameter("waterDispender") != null ? 1 :0;
		int coffeeMachine = req.getParameter("coffeeMachine") != null ? 1 :0;
		
		MeetingRoomService meetingRoomServiceImpl = MeetingRoomService.getInstance();
		meetingRoomServiceImpl.createRoom(meetingName, capacity, ratings, cost, projector, wifi, tv, conCall, whiteboard, waterDispender, coffeeMachine);
	}

}
