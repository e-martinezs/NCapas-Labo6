<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<td>${student.cStudent}</td>
		</tr>
		<tr>
			<th>Nombre</th>
			<td>${student.sName}</td>
		</tr>
		<tr>
			<th>Apellido</th>
			<td>${student.lName}</td>
		</tr>
		<tr>
			<th>Edad</th>
			<td>${student.sAge}</td>
		</tr>
		<tr>
			<th>Estado</th>
			<td>${student.activeDelegate}</td>
		</tr>
	</table>
</body>
</html>