<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <title>Create Meeting Room</title>
    <script>

     function ValidateEmpty(){
          var valueName = document.getElementById('meetingName').value;
          var valueCapacity = document.getElementById('capacity').value;
          if (valueName === '') {
            alert('Enter Meeting name');
          }
          if (valueCapacity === '') {
            alert('Enter seating capacity');
          }
     	}

        function cancelFunction() {
            var txt;
            var r = confirm("Are you sure you want to cancel ?");
            if (r == true) {
                txt = "OK!";
                var valueName = document.getElementById('meetingName').value;
                var valueCapacity = document.getElementById('capacity').value;

                if(valueName != "")
                    document.getElementById("meetingName").value = "";

                if(valueCapacity != "")
                    document.getElementById("capacity").value = "";    

            } else {
              txt = "Cancel";
            }
            document.getElementById("cancel").innerHTML = txt;
          }
    
  </script>


</head>

<body>

                            <!--Starting of navigational bar-->
    <nav class="navbar navbar-expand-sm bg-danger navbar-dark" style="height: 80px;"> 
        <a class="navbar-brand"><h1 style="margin-left: 90px;">Meetopia</h1></a>
    </nav>
                            <!--End of navigational bar-->
    <div>
        <h4 style="margin-left: 420px; margin-top: 30px; font-family: Georgia, 'Times New Roman', Times, serif;">This screen allows admin to create meeting rooms</h4>
    </div>
   

    </br>
    </br>
                              <!--starting of form-->

    <div class="card" style="width: 500px; margin-left: 400px;" >
       
        <div class="card-body card border-danger mb-3">
        <form method="post" action="CreateRoomServlet">
	            <div class="form-group ">
	                <label for="meetingName" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;">Meeting_Room Name</label>
	                <input type="text" class="form-control card border-danger mb-3" id="meetingName" placeholder="Enter Meeting Name" name="meetingName" required>
	                <div class="valid-feedback">Valid.</div>
	                <div class="invalid-feedback">Meeting name cannot be empty</div>
	            </div>
	            
	            </br>
	
	            <div class="form-group" >
	                <label for="capacity" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;">Seating capacity</label>
	                <input type="text" class="form-control card border-danger mb-3" style="width: 200px;" id="capacity" name="capacity" required>
	                <div class="valid-feedback">Valid.</div>
	                <div class="invalid-feedback">Field cannot be empty</div>
	            </div>
	            
	            <div class="form-group" >
	                <label for="ratings" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;">Ratings</label>
	                <input type="numeric" class="form-control card border-danger mb-3" style="width: 200px;" id="ratings" name="ratings" required>
	                <div class="valid-feedback">Valid.</div>
	                <div class="invalid-feedback">Field cannot be empty</div>
	            </div>
	            
	            <div class="form-group" >
	                <label for="cost" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;">Cost Per Hours</label>
	                <input type="text" class="form-control card border-danger mb-3" style="width: 200px;" id="cost" name="cost" required>
	                <div class="valid-feedback">Valid.</div>
	                <div class="invalid-feedback">Field cannot be empty</div>
	            </div>
	            
	            </br>
	
	            <div class="form-check">
	                <label for="amenities" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;" >Amenities Available</label>
	                </br>
	
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="projector" value="projector">Projector
	                </label>
	              </div>
	              <div class="form-check">
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="wifi" value="wifi">Wifi Connection
	                </label>
	              </div>
	              <div class="form-check">
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="tv" value="tv">TV
	                </label>
	              </div> 
	              <div class="form-check">
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="conCall" value="conCall">Conference Call Facility
	                </label>
	              </div> 
	              <div class="form-check">
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="whiteboard" value="whiteboard">Whiteboard
	                </label>
	              </div> 
	              <div class="form-check">
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="waterDispender" value="waterDispender">Water Dispenser
	                </label>
	              </div> 
	              <div class="form-check">
	                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
	                  <input type="checkbox" class="form-check-input" name="coffeeMachine" value="coffeeMachine">Coffee Machine
	                </label>
	              </div> 
	            </br>
	
	            <div>
	                <input type="submit" id = "save" class="btn btn-danger" name = "save" value="Save" style="margin-left: 170px;" onclick="ValidateEmpty()"/>
	
	                <input type="button" id = "cancel" class="btn btn-danger" name = "cancel" value="Cancel" onclick="cancelFunction()"/>
	                
	            </div>
      		</form>
        </div>
    
    </div>
                                           <!--End of form-->
    
</body>
</html>