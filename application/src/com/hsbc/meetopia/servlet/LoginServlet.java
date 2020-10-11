package com.hsbc.meetopia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
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

		PrintWriter out = response.getWriter();

		String userId = request.getParameter("uname");
		String email = request.getParameter("email");

		UserService userService = UserService.getInstance();
		User user = userService.loginUser(userId, email);

		if (user != null) {
			out.println("alert(\"" + "Logged In Successfully" + "\")");

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss A");
			LocalDateTime now = LocalDateTime.now();
			session.setAttribute("lastLoggedIn", dtf.format(now));

			if (user.getRole().equals("admin")) {
				response.sendRedirect("Admin_Page.jsp");
			} else if (user.getRole().equals("manager")) {
				response.sendRedirect("ManagerPage");
			} else {
				response.sendRedirect("member.jsp");
			}
		} else {
			out.println("alert(\"" + "Incorrect User ID/Email" + "\")");
		}
	}
}
