<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: rgba(105, 105, 105, 0.13);">

	<div class="container"
		style="position: relative; margin-top: 200px; background-color: rgb(255, 61, 61); width: 800px; height: 310px;">
		<h2>Meetopia - Login</h2>
		<p></p>
		<form action="Login" method="POST" class="needs-validation" novalidate>
			<div class="form-group">
				<label for="uname" style="color: ghostwhite;">User-ID:</label> <input
					type="text" class="form-control" id="uname"
					placeholder="Enter User-ID" name="uname" required>
				<div class="valid-feedback" style="color: black;">Valid.</div>
				<div class="invalid-feedback" style="color: black;">Please
					fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="email" style="color: ghostwhite;">Email:</label> <input
					type="email" class="form-control" id="email"
					placeholder="Enter valid email-ID in this format : abc@xyz.com"
					name="email" required>
				<div class="valid-feedback" style="color: black;">Valid.</div>
				<div class="invalid-feedback" style="color: black;">Please
					fill this field with a valid email-ID format like - abc@xyz.com</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<script>
		// Disable form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Get the forms we want to add validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>

</body>
</html>
