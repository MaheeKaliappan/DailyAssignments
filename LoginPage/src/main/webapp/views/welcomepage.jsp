<%@page import="org.json.JSONObject"%>
<%@page import="loginmodel.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
	button {background-color: #555555;}
	button {color : white; }
</style>
</head>
<body>
	<br><br><br><br><br><br><br>
	<div class="container">
		<h2><center>WelCome Page</center></h2>
		<div class="col-md-offset-3 col-md-7">
   <div class="panel panel-default">
   <div class="panel-body">
   			
		<%JSONObject jsonObject = (JSONObject) request.getAttribute("jsonObject");
		User user = (User) request.getAttribute("user");
		out.print("User First Name      : "+user.getUserFirstName()+"<br>");
		out.print("User Last  Name      : "+user.getUserLastName()+"<br>");
		
		out.print("User Role Id         :"+jsonObject.get("role_id")+"<br>");
		out.print("User Date Of Joining : "+jsonObject.get("date_of_joining")+"<br>");%>	
		
   </div>
   </div>
   </div>
		
	</div>
</body>
</html>