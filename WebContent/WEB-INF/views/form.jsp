<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
		<label>Ingrese un nombre: </label>
		<form:input type="text" name="name" path="sName"/><br>
		
		<label>Ingrese un apellido: </label>
		<form:input type="text" name="lname" path="lName"/><br>
		
		<label>Ingrese edad: </label>
		<form:input type="number" name="age" path="sAge"/><br>
		
		<label>Estado del estudiante: </label>
		<form:radiobutton name="status" path="bActive" value="true"/><label>Activo</label><br>
		<form:radiobutton name="status" path="bActive" value="false"/><label>Inactivo</label><br>
		
		<form:input type="hidden" name="code" path="cStudent"/>
		<input type="submit" value="${buttonLabel}">
	</form:form>
</body>
</html>