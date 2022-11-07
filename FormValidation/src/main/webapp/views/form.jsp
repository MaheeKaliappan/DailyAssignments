<!DOCTYPE html>
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
		<h2>Application Form</h2>
		<form class="form-horizontal" action="formValidation" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName">First
					Name:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="firstName"
						placeholder="Enter First Name" name="firstName">

					<p id="firstNameErrorMsg" style="color: red;"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Last
					Name:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="lastName"
						placeholder="Enter Last Name" name="lastName">
					<p id="lastNameErrorMsg" style="color: red;"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email">
					<p id="emailErrorMsg" style="color: red;"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mobileNumber">Mobile
					Number:</label>
				<div class="col-sm-5">
					<input type="number" class="form-control" id="mobileNumber"
						placeholder="Enter Mobile Number" name="mobileNumber">
					<p id="mobileNumberErrorMsg" style="color: red;"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="aadharNumber">Aadhar
					Number:</label>
				<div class="col-sm-5">
					<input type="number" class="form-control" id="aadharNumber"
						placeholder="Enter Aadhar Number" name="aadharNumber">
					<p id="aadharNumberErrorMsg" style="color: red;"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dateOfBirth">Date
					Of Birth:</label>
				<div class="col-sm-5">
					<input type="date" class="form-control" id="dateOfBirth"
						placeholder="Enter Date Of Birth" name="dateOfBirth">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-5">
					<br> <input type="radio" id="male" name="gender" value="Male">
					  <label for="html">Male</label>   <input type="radio" id="Female"
						name="gender" value="female">   <label for="female">Female</label>
					<input type="radio" id="others" name="gender" value="others">
					  <label for="others">Others</label><br>

				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button onclick="validation()" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<script>

	
	function validation() {
		
	    var regex =  /^[A-Z][a-zA-Z]*$/;
	    var ctrl =  document.getElementById("firstName").value;
	    
	   	if(regex.test(ctrl))
   		{
	   		document.getElementById("firstNameErrorMsg").innerHTML = "";	
	   		
   		}
	   	else
   		{
	   		document.getElementById("firstNameErrorMsg").innerHTML = "First Name is Not Valid";
	   		document.getElementById("firstName").focus();
	   	 	event.preventDefault();
   		}
	    var regex =/^[A-Z][a-zA-Z]*$/;
	    var ctrl =  document.getElementById("lastName").value;
	   	if(regex.test(ctrl))
   		{
	   		document.getElementById("lastNameErrorMsg").innerHTML = "";
   		}
	   	else
   		{
	   		document.getElementById("lastNameErrorMsg").innerHTML = "Last Name is Not Valid";
	   		document.getElementById("lastName").focus();
	   	 	event.preventDefault();
   			
   		}
	    var regex =/[A-Za-z0-9+_.-]+@(.+)/;
	    var ctrl =  document.getElementById("email").value;
	   	if(regex.test(ctrl))
   		{
	   		document.getElementById("emailErrorMsg").innerHTML = "";
   		}
	   	else
   		{
	   		document.getElementById("emailErrorMsg").innerHTML = "Email Id is Not Valid";
	   		document.getElementById("email").focus();
	   	 	event.preventDefault();
   			
   		}
	    var regex =/[6-9][0-9]{9}/; "^[6-9][0-9]{9}$";
	    var ctrl =  document.getElementById("mobileNumber").value;
	   	if(regex.test(ctrl))
   		{
	   		document.getElementById("mobileNumberErrorMsg").innerHTML = "";
   		}
	   	else
   		{
	   		document.getElementById("mobileNumberErrorMsg").innerHTML = "Mobile Number is Not Valid";
	   		document.getElementById("mobileNumber").focus();
	   	 	event.preventDefault();
   			
   		}
	    var regex =/^[0-9]{16}$/;
	    var ctrl =  document.getElementById("aadharNumber").value;
	   	if(regex.test(ctrl))
   		{
	   		document.getElementById("aadharNumberErrorMsg").innerHTML = "";
   		}
	   	else
   		{
	   		document.getElementById("aadharNumberErrorMsg").innerHTML = "Aadhar Number is Not Valid";
	   		document.getElementById("aadharNumber").focus();
	   	 	event.preventDefault();
   			
   		}
	    
	}

</script>
</body>
</html>
