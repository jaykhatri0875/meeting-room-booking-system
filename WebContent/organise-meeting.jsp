<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Organise Meeting</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
        <div class="title text-center"><h3>Meeting Details</h3></div>
        <div class="row justify-content-center">
            <div class="card col-7">
                <div class="card-body">
                    <form>
                        <div class="form-group">
                          <label for="meetingName">Meeting Name:</label>
                          <input type="text" class="form-control" id="meetingName" placeholder="Enter Meeting Name" required>
                        </div>
                        <div class="form-group">
                          <label for="meetingDate">Meeting Date:</label>
                          <input type="date" class="form-control" id="meetingDate" required>
                        </div>
                        <div class="form-group">
                          <label for="meetingTime">Meeting Time:</label>
                          <input type="time" class="form-control" id="meetingTime" required>
                        </div>
                        <div class="form-group">
                            <label for="duration">Duration:</label>
                            <div class="row">
                                <div class="col-6">
                                    <input type="number" class="form-control" id="durationHrs" required>
                                    <label for="durationHrs">Hrs</label>
                                </div>
                                <div class="col-6">
                                    <input type="number" class="form-control" id="durationMin" required>
                                    <label for="durationMin">Min</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group">
                                <label for="meetingName">Search Member: </label>
                                <input type="text" class="form-control" id="Search Member" placeholder="Search Member Name" required>
                              </div>
                        </div>
                        <div class="form-group">
                            <label>List of Added Members: </label>
                            <ol class="list-group">
                                <li class="list-group-item">Cras justo odio</li>
                                <li class="list-group-item">Dapibus ac facilisis in</li>
                                <li class="list-group-item">Morbi leo risus</li>
                              </ol>
                        </div>
                        <div class="form-group">
                            <label for="meetingRoom">Meeting Room:</label>
                          <input type="text" class="form-control" id="meetingRoom" placeholder="Enter Meeting Room ID" required>
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
                                                <input class="form-check-input" type="radio" name="meetingType" id="inlineRadio1" value="option1" required>
                                                <label class="form-check-label" for="inlineRadio1">Classroom Training</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="meetingType" id="inlineRadio2" value="option2" required>
                                                <label class="form-check-label" for="inlineRadio2">Online Training</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="meetingType" id="inlineRadio3" value="option3" required>
                                                <label class="form-check-label" for="inlineRadio3">Conference Call</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="meetingType" id="inlineRadio3" value="option3" required>
                                                <label class="form-check-label" for="inlineRadio3">Business</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Save & Continue</button> <a href="./manager-page.jsp ml-1" class="btn btn-danger">Cancel</a>
                      </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>