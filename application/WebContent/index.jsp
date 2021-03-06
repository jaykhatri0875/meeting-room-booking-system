<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Meetopia</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body style="background-color: rgba(105, 105, 105, 0.13);">


<nav class="navbar navbar-expand-sm bg-danger navbar-dark fixed-top ">
  <a class="navbar-brand" href="#">Meetopia</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#MeetingRooms">Meeting Rooms</a>
      </li>
    </ul>
  </div>  
</nav>

<div class="container" style="margin-top:100px">
  <div class="row">
    <div class="col-sm-4">
      
      <h3 style="font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;">Steps to Login - </h3>
      <p>Please these two steps : </p>
      <ul class="nav nav-pills flex-column">
        
        <li class="nav-item">
          <a class="nav-link" href="importUsers.jsp" target="_blank">Step1 - Import a JSON File</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp" target="_blank">Step2 - after Importing  - Now LOGIN</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2 style="font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;">What is MEETOPIA ?</h2>
     
      <p>We are a One-Stop Solution for booking your Meetings! 
          We provide options like  - the Admin can login and create Rooms, the Managers can schedule Meetings in the Rooms created 
          and the employees can login and check the Meetings scheduled for them on thei profile page.
          We also provide various Amenties in the Meeting Rooms - Projector, WiFi Connection, Conference call facility, Whiteboard, Water dispenser, TV and Coffee machine.
      </p>
      <p style="font-style:inherit; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;">So Enjoy Booking and Scheduling Meetings on MEETOPIA!! </p>
      <br>
      
      <!-- meeting rooms -->
 
 <div class="accordion" id="MeetingRooms" style="margin-top:50px">
    <h2 style="font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;">Meeting Rooms</h2>
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          ClassRoom Training
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#MeetingRooms">
      <div class="card-body">
        In a ClassRoom Training , the Whiteboard and Projector are provided by default. The Seating Capacity in a ClassRoom Training should not be more than 35.
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Online Training
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#MeetingRooms">
      <div class="card-body">
        In an Online Training, the WiFi and Projector are provided by default. The Seating Capacity in an Online Training should not be more than 100. 
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Conference Call
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#MeetingRooms">
      <div class="card-body">
        In a Conference Call, the Conference Call Facilities are provided by default. The Seating Capacity is not fixed.
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingFour">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          Business Meeting
        </button>
      </h2>
    </div>
    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#MeetingRooms">
      <div class="card-body">
        In a Business Meeting , the Projector is provided by default. The Seating Capacity is not fixed.
      </div>
    </div>
  </div>

</div>
 
 
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0; background-color:rgb(248, 63, 63); color:white; font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
  <p style="font-size:x-large;">Meetopia</p>
</div>

</body>
</html>
