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

	<nav class="navbar navbar-light bg-danger">
		<span class="navbar-brand mb-0 h1 text-white">Meetopia</span>
	</nav>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Organise Meeting</h1>
		</div>
	</div>

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
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">
								<strong>+</strong> Add Members
							</button>
						</div>
						<div class="form-group">
							<label>List of Added Members: </label>
							<div id="selected-members">
								<small class="text-muted">Click on added members(if any)
									to remove.</small>
								<ul class="list-group list">
									<!-- List of selected members come here -->
								</ul>

							</div>
						</div>
						<div class="form-group">
							<label for="meetingRoom">Meeting Room:</label> <input
								name="meetingRoom" type="text" class="form-control"
								id="meetingRoom" placeholder="Enter Meeting Room ID" required>
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
						<a href="./manager-page.jsp" class="btn btn-danger ml-1">Cancel</a>
					</form>

					<!-- Add Members Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Select
										Members</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div id="available-members">
										<br>
										<hr class="mt-0">
										<small class="text-muted">+ Click on a member(if any)
											to add to this meeting.</small><br> <small class="text-muted">+
											Check the list of added members in the form to confirm.</small>
										<hr>
										<input type="text" class="search form-control mb-1"
											placeholder="Search Member by Name/ID">
										<button class="sort btn btn-primary my-2" data-sort="name">
											Sort by Name</button>
										<button class="sort btn btn-primary my-2" data-sort="id">
											Sort by ID</button>
										<ul class="list-group list">
											<!-- List of available members come here -->
										</ul>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Done</button>
								</div>
							</div>
						</div>
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

	<!-- LIST.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"
		integrity="sha512-AYlzeu/5Cexb6uN6uQ0LfoRx33CgMticI4+eEsmPz9QxxyuLr0zd4MA+4hxLqISNs8769A+FVnBCuaMne6d0+w=="
		crossorigin="anonymous"></script>

	<!-- SCRIPT.JS -->
	<script src="script.js"></script>
</body>
</html>