package modelo;

import java.time.LocalDate;

public class Alumno {

	//Atributos o propiedades o variables de instancia
	private int id;
	private String nombre;
	private String carrera;
	private LocalDate fechaNacimiento;
	
	//Constructores
	public Alumno() {
	}

	//constructor para crear alumno, sin id porque es
	//automatico
	public Alumno(String nombre, String carrera, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.carrera = carrera;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public Alumno(int id, String nombre, String carrera, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.carrera = carrera;
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	//Getter and Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
	
}
