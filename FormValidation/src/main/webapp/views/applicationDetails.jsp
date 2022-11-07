<!DOCTYPE html>
<%@page import="formValidation.model.Form"%>
<html lang="en">
<head>
<title>Form Validation</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Applicant Details</h2>
		<div class="panel panel-default">
				<div class="panel-body">
	
		<%Form form = (Form)request.getAttribute("form"); 
		out.print("First Name    : "+form.getFirstName()+"<br><br>");
		out.print("Last Name     : "+form.getLastName()+"<br><br>");
		out.print("Mail Id       : "+form.getEmailId()+"<br><br>");
		out.print("Mobile Number : "+form.getMobileNumber()+"<br><br>");
		out.print("Aadhar number : "+form.getAadharNumber()+"<br><br>");
		out.print("Date Of Birth : "+form.getDateOfBirth()+"<br><br>");
		out.print("Gender        : "+form.getGender()+"<br><br>");
		
		
		
		%>
		</div>
		</div>
	</div>
	

	
	</body>
</html>
