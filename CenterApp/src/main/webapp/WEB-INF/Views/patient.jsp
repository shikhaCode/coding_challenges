<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/js/validate.js"></script>


</head>
<body>
<form action="addparticipant"  name="myForm" onsubmit="return validation()">

PatientName:<input type="text" name="name" required/><br><br>
Age:<input type="text" name="age" required/><br><br>
QuarantineId:<select name="placeName">
<% 
try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection =   DriverManager.getConnection
        ("jdbc:mysql://localhost/activitydb?user=root&password=123456");

   Statement statement = connection.createStatement() ;

   resultset =statement.executeQuery("select quarantineid from quarantine_center") ;
%>
<%
while (resultset.next()){
	%>
	<option ><%= resultset.getString(1) %></option>
	<%

 }
%>

</select>

<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>




<input type="submit" value="submit"> 


  </form>

</body>
</html>