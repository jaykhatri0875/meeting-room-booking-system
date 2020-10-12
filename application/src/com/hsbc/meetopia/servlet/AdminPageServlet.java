package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meetopia.model.Room;
import com.hsbc.meetopia.model.User;
import com.hsbc.meetopia.service.RoomService;

public class AdminPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");

		RoomService roomService = RoomService.getInstance();
		Collection<Room> rooms = roomService.fetchAllRooms();

		req.setAttribute("rooms", rooms);
		req.setAttribute("user", user);

		RequestDispatcher rd = req.getRequestDispatcher("adminPage.jsp");
		rd.forward(req, res);
	}
}