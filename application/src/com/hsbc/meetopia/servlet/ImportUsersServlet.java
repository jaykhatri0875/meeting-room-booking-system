package com.hsbc.meetopia.servlet;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hsbc.meetopia.model.User;
import com.hsbc.meetopia.service.UserService;

public class ImportUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private boolean flag = true;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String file = request.getParameter("filename");
		UserService userService = UserService.getInstance();
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
			JSONArray jsonArray = (JSONArray) jsonObject.get("users");
			for (Object object : jsonArray) {
				JSONObject record = (JSONObject) object;
				String name = (String) record.get("name");
				String email = (String) record.get("email");
				long phone = (long) record.get("phone");
				String role = (String) record.get("role");

				User user = new User(name, email, phone, role);
				User userCreated = userService.saveUser(user);
				if (userCreated != null) {
					System.out.println("User added with User ID: " + userCreated.getuID() + " and Email: "
							+ userCreated.getEmail());
				}
			}
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}