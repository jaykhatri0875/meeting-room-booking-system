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
<title>Manager's Page</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>

	<nav class="navbar navbar-light bg-danger">
		<span class="navbar-brand mb-0 h1 text-white">Meetopia</span>
	</nav>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Manager's Page</h1>
		</div>
	</div>
	<%
		Collection<Meeting> meetings = (Collection) request.getAttribute("meetings");
	User user = (User) request.getAttribute("user");
	String lastLoggedIn = (String) request.getAttribute("lastLoggedIn");
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h3>Profile</h3>
				<div class="card">
					<div class="card-body bg-danger">
						<h3 class="card-title text-white">
							<%=user.getName()%>
						</h3>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><strong>Email: </strong> <%=user.getEmail()%></li>
						<li class="list-group-item"><strong>Last Logged In:
						</strong> <%=lastLoggedIn%></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-8">
				<h3>Scheduled Meetings</h3>
				<table class="table">
					<thead class="bg-danger">
						<tr>
							<th class="text-white" scope="col">Meeting ID</th>
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
		<div class="row justify-content-center mt-1">
			<div class="col-3">
				<a href="./organiseMeeting.jsp" class="btn btn-danger btn-lg">Organise
					Meeting</a>
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

	<!-- LIST.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"
		integrity="sha512-AYlzeu/5Cexb6uN6uQ0LfoRx33CgMticI4+eEsmPz9QxxyuLr0zd4MA+4hxLqISNs8769A+FVnBCuaMne6d0+w=="
		crossorigin="anonymous"></script>

	<!-- SCRIPT.JS -->
	<script src="script.js"></script>
</body>
</html>