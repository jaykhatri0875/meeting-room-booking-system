package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meetopia.model.User;
import com.hsbc.meetopia.service.UserService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userId = request.getParameter("uname");
		String email = request.getParameter("email");

		UserService userService = UserService.getInstance();
		User user = userService.loginUser(userId, email);

		if (user != null) {
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
			String currentTime = format.format(now);

			Cookie cookie = Servlets.getCookie(request, "lastLoggedIn");
			if (cookie == null) {
				Cookie cookie1 = new Cookie("lastLoggedIn", currentTime);
				Servlets.addCookie(cookie1, response);
			}

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			if (user.getRole().equals("admin")) {
				response.sendRedirect("AdminPage");
			} else if (user.getRole().equals("manager")) {
				response.sendRedirect("ManagerPage");
			} else {
				response.sendRedirect("MemberPage");
			}
		} else {
			out.print("Incorrect User ID or Email");
		}
		out.close();
	}
}
