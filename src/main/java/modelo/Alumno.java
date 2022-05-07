package modelo;

public class Alumno {

	//Atributos o propiedades o variables de instancia
	private int id;
	private String nombre;
	private String carrera;
	
	//Constructores
	public Alumno() {
	}

	//constructor para crear alumno, sin id porque es
	//automatico
	public Alumno(String nombre, String carrera) {
		this.nombre = nombre;
		this.carrera = carrera;
	}
	
	
	public Alumno(int id, String nombre, String carrera) {
		this.id = id;
		this.nombre = nombre;
		this.carrera = carrera;
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
