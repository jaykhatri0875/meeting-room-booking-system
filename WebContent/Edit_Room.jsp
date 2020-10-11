<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <title>Edit Room</title> 
   
    <script>
        function ValidateEmpty(){
          var valueName = document.getElementById('userName').value;
          var valueCapacity = document.getElementById('capacity').value;
          if (valueName === '') {
            alert('Enter your name');
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
                var valueName = document.getElementById('userName').value;
                var valueCapacity = document.getElementById('capacity').value;

                if(valueName != "")
                    document.getElementById("userName").value = "";

                if(valueCapacity != "")
                    document.getElementById("capacity").value = "";    

            } else {
              txt = "Cancel";
            }
            document.getElementById("cancel").innerHTML = txt;
          }

        function openNav() {
            document.getElementById("mySidebar").style.width = "150px";
          
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
            document.getElementById("main").style.marginLeft= "0";
        } 

        function goBack() {
          window.history.back();
        } 

</script>

<style>
  body {
    font-family: "Lato", sans-serif;
  }
  
  .sidebar {
    height: 90%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 100px;
    left: 0;
    background-color:#111;
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
    position:sticky;
  
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
    .sidebar {padding-top: 15px;}
    .sidebar a {font-size: 15px;}
  }
  </style>


</head>

  

<body>

      <div id="mySidebar" class="sidebar">
          <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
          <a href="Admin_Page.jsp">ADMIN PAGE</a>
          <a href="Create_Room.jsp">CREATE ROOM</a>                         
          <a href="#">LOGOUT</a>
      </div>
                                                
                        <!--Starting of navigational bar-->

      <nav class="navbar navbar-expand-sm bg-danger navbar-dark" style="height: 100px;">
         <button class="openbtn" onclick="openNav()">☰</button> 
        <a class="navbar-brand"><h1 style="margin-left: 90px;">Meetopia</h1></a>
                                                         
      </nav>
                        <!--End of navigational bar-->
    <div>
        <h4 style="margin-left: 420px; margin-top: 30px; font-family: Georgia, 'Times New Roman', Times, serif;">This screen allows admin to edit meeting rooms</h4>
    </div>
   

    </br>
    </br>

    <div>
      <button onclick="goBack()" style="margin-left: 1200px;">Back</button>
    </div>
  </br>
                                    <!--starting of form-->

    <div class="card" style="width: 500px; margin-left: 400px;" >
       
        <div class="card-body card border-danger mb-3">
            <div class="form-group ">
                <label for="userName" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;">User Name</label>
                <input type="text" class="form-control card border-danger mb-3" id="userName" placeholder="Enter username" name="userName" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Name cannot be empty</div>
            </div>
            
            </br>

            <div class="form-group" >
                <label for="capacity" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;">Seating capacity</label>
                <input type="text" class="form-control card border-danger mb-3" style="width: 200px;" id="capacity" name="capacity" placeholder="Enter capacity" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Field cannot be empty</div>
            </div>
            
            </br>

            <div class="form-check">
                <label for="amenities" class="font-weight-bold" style="font-family: Georgia, 'Times New Roman', Times, serif;" >Amenities Available</label>
                </br>

                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">Projector
                </label>
              </div>
              <div class="form-check">
                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">Wifi Connection
                </label>
              </div>
              <div class="form-check">
                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">TV
                </label>
              </div> 
              <div class="form-check">
                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">Conference Call Facility
                </label>
              </div> 
              <div class="form-check">
                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">Whiteboard
                </label>
              </div> 
              <div class="form-check">
                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">Water Dispenser
                </label>
              </div> 
              <div class="form-check">
                <label class="form-check-label" style="font-family: Georgia, 'Times New Roman', Times, serif;">
                  <input type="checkbox" class="form-check-input" value="">Coffee Machine
                </label>
              </div> 
            </br>

            <div>
              <input type="button" id = "save" class="btn btn-danger" name = "save" value="Save" style="margin-left: 170px;" onclick="ValidateEmpty()"/>

              <input type="button" id = "cancel" class="btn btn-danger" name = "cancel" value="Cancel" onclick="cancelFunction()"/>
                
            </div>
        
        </div>
    
    </div>
                                            
                                              <!--End of form-->
    
</body>
</html>