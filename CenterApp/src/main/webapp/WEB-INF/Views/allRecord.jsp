<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="details">
			<table class="table table-sm table-bordered table-dark" style="width:70%" >
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Age</th>
					
				<!-- 	<th>activity</th>
			       <th>activity</th>
					 -->
					
				</tr>
				<c:forEach var="S" items="${parti}">
					<tr>
					<td>${S.patientId }</td>
						<td>${S.patientName }</td>
						<td>${S.age }</td>
						<%-- <td>${S.activity.activityID }</td>
				       <td>${S.activity.name }</td>
						 --%>
						 
						 
					
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>


</body>
</html>