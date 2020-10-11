package com.hsbc.meetopia.servlet;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class ImportUserJsonServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String file = request.getParameter("filename");
		System.out.println(file);
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
			JSONArray jsonArray = (JSONArray) jsonObject.get("users");
			for(Object object : jsonArray) {
				JSONObject record = (JSONObject) object;
				String uid = (String) record.get("uid");
				String name = (String) record.get("Membername");
				String email = (String) record.get("email");
				String phone = (String) record.get("phone");
				String role = (String) record.get("role_Member");
				String credit = (String) record.get("credit");
				
				//Insert into users and user role.
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
