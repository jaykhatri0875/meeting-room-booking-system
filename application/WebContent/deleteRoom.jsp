<%@page import="com.hsbc.meetopia.service.RoomService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		try {
			
			String meetingId = (String)request.getParameter("room_id").trim();
			System.out.println("jsp file : " + meetingId);
			RoomService meetingRoomService = RoomService.getInstance();
			int value = meetingRoomService.deleteRoom(meetingId);
			
			if(value > 0)
				response.sendRedirect("adminPage.jsp");
			else{
				response.sendRedirect("adminPage.jsp");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>


</body>
</html>