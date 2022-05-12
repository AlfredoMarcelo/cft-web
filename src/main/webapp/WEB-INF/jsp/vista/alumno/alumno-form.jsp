<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alumno</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<h1>Alumno</h1>
			<form action="/cft-web/AlumnoController" method="POST">
				<input type="hidden" name="id" value="${alumno.id}"/>
				<div class="mb-3">
					<label for="nombre" class="form-label">Nombre:</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${alumno.nombre}"/>
				</div>
				<div class="mb-3">
					<label for="carrera" class="form-label">Carrera:</label>
					<input type="text" class="form-control" id="carrera" name="carrera" value="${alumno.carrera}"/>
				</div>
				<div class="mb-3">
					<label for="nacimiento" class="form-label">Fecha de nacimiento:</label>
					<input type="date" class="form-control" id="nacimiento" name="nacimiento" value="${alumno.fechaNacimiento}"/>
				</div>
				<button class="btn btn-primary" type="submit">Guardar</button>
		</form>
		</div>
	</body>
</html>