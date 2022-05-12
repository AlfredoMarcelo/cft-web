<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Formulario para crear carrera profesional</title>
	</head>
	<body>
		<h1 class="text-center">Carrera</h1>
		<div class="container">
			<form action="/cft-web/CarreraController" method="POST">
				<input type="hidden" name="id" value="${carrera.id}"/>
				<div class="mb-3">
					<label for="nombre">Nombre:</label>
					<input type="text" class="form-control" id="carrera" name="nombre" value="${carrera.nombre}">
				</div>
				<button class="btn btn-primary" type="submit">Guardar</button>
			</form>
		</div>
	</body>
</html>