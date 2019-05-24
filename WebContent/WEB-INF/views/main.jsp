<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SpringJPA</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/findStudent">
		<label>ID: </label><input type="number" name="code" required>
		<input type="submit" value="Buscar">
	</form>
	<br>
	<table>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Estado</th>
		</tr>
		<c:forEach items="${students}" var="students">
			<tr>
				<td>${students.cStudent}</td>
				<td>${students.sName}</td>
				<td>${students.lName}</td>
				<td>${students.sAge}</td>
				<td>${students.activeDelegate}</td>
				<td>
					<form action="${pageContext.request.contextPath}/updateStudent">
						<input type="hidden" name="code" value="${students.cStudent}">
						<input type="submit" value="Editar">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="${pageContext.request.contextPath}/insertStudent" method="post">
		<input type="submit" value="Agregar un nuevo usuario">
	</form>
	
	<form action="${pageContext.request.contextPath}/deleteStudent">
		<label>Nombre: </label>
		<input type="text" name="name" required>
		<input type="submit" value="Eliminar">
	</form>
</body>
</html>