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

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("index.jsp").include(request, response);

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String currentTime = format.format(now);

		Cookie cookie = Servlets.getCookie(request, "lastLoggedIn");
		if (cookie != null) {
			Servlets.setValue(cookie, response, currentTime);
		} else {
			Cookie cookie1 = new Cookie("lastLoggedIn", currentTime);
			Servlets.addCookie(cookie1, response);
		}

		out.print("You are successfully logged out!");
		out.close();
	}
}