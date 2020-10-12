<%@page import="com.hsbc.meetopia.model.Room"%>
<%@page import="com.hsbc.meetopia.model.User"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Organise Meeting</title>
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
		<a href="./ManagerPage">Manager Page</a>
	</div>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Organise Meeting</h1>
		</div>
	</div>
	<%
		Collection<String> rooms = (Collection) request.getAttribute("rooms");
	Collection<User> users = (Collection) request.getAttribute("users");
	%>
	<div class="container">
		<div class="title text-center">
			<h3>Meeting Details</h3>
		</div>
		<div class="row justify-content-center">
			<div class="card col-7">
				<div class="card-body">
					<form id="organise-meeting" method="POST" action="createMeeting">
						<div class="form-group">
							<label for="meetingName">Meeting Name:</label> <input
								name="meetingName" type="text" class="form-control"
								id="meetingName" placeholder="Enter Meeting Name" required>
						</div>
						<div class="form-group">
							<label for="meetingDate">Meeting Date:</label> <input
								name="meetingDate" type="date" class="form-control"
								id="meetingDate" required>
						</div>
						<div class="form-group">
							<label for="meetingTime">Meeting Time:</label> <input
								name="meetingTime" type="time" class="form-control"
								id="meetingTime" required>
						</div>
						<div class="form-group">
							<label for="duration">Duration:</label>
							<div class="row">
								<div class="col-6">
									<input name="durationHrs" type="number" class="form-control"
										id="durationHrs" required min="0" max="6"> <label
										for="durationHrs">Hrs</label>
								</div>
								<div class="col-6">
									<input name="durationMin" type="number" class="form-control"
										id="durationMin" required min="0" max="59"> <label
										for="durationMin">Min</label>
								</div>
							</div>
						</div>
						<div class="form-group">
								<label for="addMember">Add memebers</label> 
								<input list="addMember" type="text" class="form-control"
								 placeholder="Add members" required>
								<%--add data from database here from database --%>>
								<datalist id = "addMember">
									<option value="1000">
									<option value="2000">
									<option value="3000">
								</datalist>
						</div>
						<div class="form-group">
							<label for="meetingRoom">Meeting Room:</label> <input
								list="meetingRoom" type="text" class="form-control"
								placeholder="Enter Meeting Room ID" required>
							<%--add data from database here from database --%>
							<datalist id="meetingRoom">
								<%
									for (String roomId : rooms) {
								%>
								<option value=<%=roomId%>>
									<%
										}
									%>
								
							</datalist>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="meetingType">Meeting Type: </label>
								</div>
								<div class="col-9">
									<div class="row">
										<div class="col-12">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="meetingType" id="inlineRadio1"
													value="Classroom Training" required> <label
													class="form-check-label" for="inlineRadio1">Classroom
													Training</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="meetingType" id="inlineRadio2"
													value="Online Training" required> <label
													class="form-check-label" for="inlineRadio2">Online
													Training</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-12">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="meetingType" id="inlineRadio3"
													value="Conference Call" required> <label
													class="form-check-label" for="inlineRadio3">Conference
													Call</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="meetingType" id="inlineRadio3" value="Business"
													required> <label class="form-check-label"
													for="inlineRadio3">Business</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<input type="hidden" id="selected-members-input"
							name="selectedMembers">
						<button type="submit" class="btn btn-primary ">Save &
							Continue</button>
						<a href="./managerPage.jsp" class="btn btn-danger ml-1">Cancel</a>
					</form>
					</div>
				</div>
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
