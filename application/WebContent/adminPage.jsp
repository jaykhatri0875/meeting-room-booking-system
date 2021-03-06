<%@page import="java.util.*"%>
<%@page import="com.hsbc.meetopia.model.*"%>
<%@page import="com.hsbc.meetopia.service.RoomService"%>
<%@page import="com.hsbc.meetopia.util.DatabaseUtils"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>Admin Page</title>

<script>
	function openNav() {
		document.getElementById("mySidebar").style.width = "150px";
		//document.getElementById("main").style.marginLeft = "150px";
	}
	function closeNav() {
		document.getElementById("mySidebar").style.width = "0";
		document.getElementById("main").style.marginLeft = "0";
	}
</script>

<style>
body {
	font-family: "Lato", sans-serif;
}

td, th {
	width: 700px;
}

.sidebar {
	height: 90%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 130px;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidebar a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 15px;
	color: white;
	display: block;
	transition: 0.3s;
}

.sidebar a:hover {
	color: #f1f1f1;
}

.sidebar .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 28px;
	margin-left: 5px;
}

.openbtn {
	font-size: 15px;
	cursor: pointer;
	background-color: #111;
	color: white;
	padding: 10px 15px;
	border: none;
	margin-left: 20px;
	position: sticky;
}

.openbtn:hover {
	background-color: #444;
}

#main {
	transition: margin-left .1s;
	padding: 16px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 15px;
	}
}
</style>

</head>
<body>
	<%--
		Connection con = DatabaseUtils.getRemoteConnection();
	RoomService meetingRoomService = RoomService.getInstance();
	Collection<Room> list = meetingRoomService.fetchAllRooms();
	List<Room> meetingRooms = new ArrayList<>();
	meetingRooms.addAll(list);
	--%>
	<%
		User user = (User) session.getAttribute("user");
	Collection<Room> rooms = (Collection) request.getAttribute("rooms");
	%>


	<!--Starting of navigational bar-->

	<div id="mySidebar" class="sidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;�</a>
		<a href="createRoom.jsp">CREATE ROOM</a> <a href="./Logout">LOGOUT</a>
	</div>


	<!--Starting of navigational bar-->

	<nav class="navbar navbar-expand-sm bg-danger navbar-dark"
		style="height: 130px;">

		<button class="openbtn" onclick="openNav()">&#9776;</button>
		<a class="navbar-brand"><h1 style="margin-left: 80px;">Meetopia</h1></a>



		<!--Displaying admin details-->
		<div class="card card border-danger mb-3"
			style="margin-left: 850px; margin-right: 50px; margin-top: 15px; height: 130px; font-family: Georgia, 'Times New Roman', Times, serif; font-size: 12px;">
			<div class="card-body" style=" width:400px">
				<p class="card-text">
					Name :
					<%=user.getName()%></p>
				<p class="card-text">
					Email ID :
					<%=user.getEmail()%></p>
			</div>
		</div>

	</nav>
	<!--End of navigational bar-->

	</br>

	<div>
		<h4
			style="margin-left: 420px; font-family: Georgia, 'Times New Roman', Times, serif;">This
			screen allows admin to create and edit meeting rooms</h4>
	</div>



	</br>
	</br>

	<!--starting of "cards that display lists of rooms"-->

	<div class="card" style="width: 950px; margin-left: 280px;">

		<div class="card-deck">
			<div class="card bg-light; card border-danger mb-3">
				<div class="card-body text-center">
					<h5 style="font-family: Georgia, 'Times New Roman', Times, serif;"
						class="font-weight-bold">List of meeting rooms</h5>
					</br> <label for="meetingedit"
						style="font-family: Georgia, 'Times New Roman', Times, serif;">Click
						on the Room ID to edit.</label> </br>
					<div class="list-group; card border-danger mb-3"
						style="font-family: Georgia, 'Times New Roman', Times, serif;">
						<!-- <a href="editRoom.jsp" class="list-group-item list-group-item-action" >First item</a>
                                <a href="editRoom.jsp" class="list-group-item list-group-item-action">Second item</a>
                                <a href="editRoom.jsp" class="list-group-item list-group-item-action">Third item</a> -->
						<table id="tab1">
							<tr>
								<th>Room Id</th>
								<th>Edit / Delete</th>
							</tr>

							<%
								try {
								int count = 1;
								for (Room meetingRoom : rooms) {

									out.print("<tr>");

									out.print("<td>");
									out.print(meetingRoom.getuId());
									out.print("</td>");
									//System.out.println(meetingRoom.getuId());
									out.print("<td>");
									out.print("<button type='button' class=' fa fa-edit btn btn-success' onclick='openEvent1(this)' id='edit"
									+ (count++) + "' name='" + meetingRoom.getuId() + "'> </button>");
									out.println("&nbsp");
									out.print("<button type='button' class=' fa fa-trash btn btn-danger' onclick='openEvent2(this)' id='delete"
									+ (count++) + "' name='" + meetingRoom.getuId() + "'></button>");
									out.print("</td>");

									out.print("</tr>");

								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							%>
						</table>


					</div>
				</div>
			</div>

			<!--end of "cards that display lists of rooms"-->

			<!--starting of "create room link"-->

			<div style="height: 300px;">
				<div class="card bg-light; card border-danger mb-3">
					<div class="card-body text-center">
						<p style="font-family: Georgia, 'Times New Roman', Times, serif;"
							class="font-weight-bold">
							To create a room click here <a href="createRoom.jsp">Create
								Room</a>
						</p>
					</div>
				</div>
			</div>

			<!--end of "create room link"-->
		</div>
	</div>



	</br>
	</br>

	<script type="text/javascript">
		function openEvent1(id) {
			console.log("In function open event 1");
			var no1 = id.getAttribute("name");
			console.log(no1);
			//var no1 = document.getElementById("edit").name;
			//console.log("room id : " + String(id));
			window.location = "editRoom.jsp?room_id=" + no1;

		}

		function openEvent2(id) {
			console.log("In function open event 2");
			var no1 = id.getAttribute("name");
			console.log("room id : " + no1);
			//var decision = confirm("Are you sure you want to delete ?");
			//if(decision == true)
			window.location = "deleteRoom.jsp?room_id=" + no1;
			//else
			//window.location = "adminPage.jsp";
		}
	</script>


</body>
</html>