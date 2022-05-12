<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>App Mtriculas CFT</title>
	</head>
	<body>
		<h1 class="text-center">Bienvenido a CFT Arica</h1>
		<div class="container">
			<div class="row mt-4">
				<div class="col-3">
					<a class="btn btn-warning" href="/cft-web/AlumnoController?accion=listar">
						Ver Alumnos
					</a>
				</div>
				<div class="col-3">
				<a class="btn btn-warning" href="/cft-web/AlumnoController?accion=form">
					Crear alumno
				</a>
				</div>
				<div class="col-3">
				<a class="btn btn-danger" href="/cft-web/CarreraController?accion=crear">
					Crear Carrera
				</a>
				</div>
				<div class="col-3">
				<a class="btn btn-danger" href="/cft-web/CarreraController?accion=listar">
					Listar carreras
				</a>
				</div>
			</div>
		</div>
	</body>
</html>