<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Import Users</title>
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
<body
	style="background-color: rgba(105, 105, 105, 0.13); margin-top: 200px;">

	<div class="container mt-3"
		style="margin-top: 200px; margin-left: 400px; background-color: rgb(255, 61, 61); width: 500px; height: 300px;">
		<h2>Import Users from a JSON File</h2>
		<p>To import a JSON file which has the users info:</p>
		<form action="ImportUsers" method="POST">
			<p>JSON file:</p>
			<div class="custom-file mb-3">
				<input type="file" class="custom-file-input" id="customFile"
					name="filename" required> <label class="custom-file-label"
					for="customFile" style="width: 400px;">Choose a JSON file</label>
			</div>



			<div class="mt-3">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>

	<script>
		//the following code reflects the name of the file appear on select
		$(".custom-file-input").on(
				"change",
				function() {
					var fileName = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.jsp(fileName);
				});
	</script>

</body>
</html>