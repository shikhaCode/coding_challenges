<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>



	<form action="/updateD" name="myForm" onsubmit ="return validationForm()">
	<label for="id">Enter id</label><br> <input
			type="text" id="id" name="id" placeholder="id"><br>
		<label for="place">Enter name</label><br> <input
			type="text" id="name" name="name" placeholder="name"><br>

		<label for="age">Enter age</label><br> <input
			type="text" id="age" name="age" placeholder="strength"><br><br>
		<input type="submit" value="Submit">
	</form>
</div>



</body>
</html>