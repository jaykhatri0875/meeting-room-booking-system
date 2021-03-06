<%@page import="com.hsbc.meetopia.model.User"%>
<%@page import="com.hsbc.meetopia.model.Meeting"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Member Page</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>

	<nav class="navbar navbar-light bg-danger justify-content-start">
      <button class="openbtn btn btn-danger mr-1" onclick="openNav()">&#9776;</button>
      <a class="navbar-brand mb-0 h1 text-white" href="./index.jsp">Meetopia</a>
  </nav>
	
	<div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="./Logout">Logout</a>
    	</div>
	
	<%User user = (User) request.getAttribute("user"); %>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Member's Page</h1>
			<div><h2>Name : <%=user.getName()%></h2></div>
		</div>
	</div>
	<div>
	<h1></h1>
	</div>
	<div class="container" style = "margin-top:50px">
		<h3>Scheduled Meetings</h3>
		<div class="row">
			<%
				Collection<Meeting> meetings = (Collection) request.getAttribute("meetings");
			%>
			<div class="col-12">
				<table class="table">
					<thead class="bg-danger">
						<tr>
							<th class="text-white" scope="col">#</th>
							<th class="text-white" scope="col">Meeting Name</th>
							<th class="text-white" scope="col">Meeting Room</th>
							<th class="text-white" scope="col">Start Date</th>
							<th class="text-white" scope="col">Time</th>
							<th class="text-white" scope="col">Duration</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Meeting meeting : meetings) {
						%>

						<tr>
							<td><%=meeting.getuID()%></td>
							<td><%=meeting.getTitle()%></td>
							<td><%=meeting.getBooking().getRoomId()%></td>
							<td><%=meeting.getBooking().getDate()%></td>
							<td><%=meeting.getBooking().getStartTime()%></td>
							<td>
								<%
									long duration = meeting.getBooking().getEndTime().getTime() - meeting.getBooking().getStartTime().getTime();
								%> <%=(duration / (1000 * 60 * 60)) % 24 + " hrs"%>
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>



	<!-- SCRIPT.JS -->
	<script src="script.js"></script>
</body>
</html>
