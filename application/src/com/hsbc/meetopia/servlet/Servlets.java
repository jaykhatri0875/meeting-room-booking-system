package com.hsbc.meetopia.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Servlets {

	private Servlets() {
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}

	public static void setValue(Cookie cookie, HttpServletResponse response, String value) {
		if (cookie != null) {
			cookie.setValue(value);
			response.addCookie(cookie);
		}
	}

	public static void addCookie(Cookie cookie, HttpServletResponse response) {
		if (cookie != null) {
			response.addCookie(cookie);
		}
	}

}
