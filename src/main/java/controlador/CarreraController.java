package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Carrera;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class CarreraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarreraController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String vistaJSP = "";
		switch(accion) {
		case "listar":
			try {
				List <Carrera> carreras = getCarreras();
				request.setAttribute("carreras", carreras);
				vistaJSP = "/WEB-INF/jsp/vista/carrera/carrera-listado.jsp";
				request
				.getRequestDispatcher(vistaJSP)
				.forward(request, response);
			} catch (SQLException | NamingException e) {
				response.sendError(500);
			}
			break;
			
		case "crear":
			vistaJSP ="/WEB-INF/jsp/vista/carrera/carrera-form.jsp";
			request
			.getRequestDispatcher(vistaJSP)
			.forward(request, response);
			break;
		case "editar":
			try{
				int carreraId = Integer.parseInt(request.getParameter("id"));
				Carrera carrera = getCarreraById(carreraId);
				request.setAttribute("carrera", carrera);
				vistaJSP = "/WEB-INF/jsp/vista/carrera/carrera-form.jsp";
				request
				.getRequestDispatcher(vistaJSP)
				.forward(request, response)
				;
			} catch (SQLException sqe) {
				sqe.printStackTrace();
				response.sendError(500);
			} catch (NamingException ne) {
				ne.printStackTrace();
				response.sendError(500);
			}
			//falta agregar case editar por id tanto en get y post
			default:
				response.sendError(404);
		}
		
		
		
	}
	
	private Carrera getCarreraById(int carreraId) throws SQLException, NamingException {
		try (
				Connection conexion = getConexion();
				//declaracion preparadas para evitar inyecciones de codigo sql(SEGFURIDAD)
				PreparedStatement declaracion = conexion.prepareStatement("SELECT * FROM carreras WHERE id = ?");
			){
				declaracion.setInt(1, carreraId);
				ResultSet rs = declaracion.executeQuery();
				if (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					return new Carrera(id, nombre);
				} else {
					return null;
				}
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int id = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch(NumberFormatException e) {
			System.err.println("se setea a 0");
		}
		
		
		String nombre = request.getParameter("nombre");
		
		if(id == 0) {
			Carrera carreraNueva = new Carrera(nombre);
			try {
				crearCarrera(carreraNueva);
				response.sendRedirect("/cft-web/CarreraController?accion=listar");
			}catch(SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}else {
			Carrera carreraEditar = new Carrera (id, nombre);
			try {
				editarCarrera(carreraEditar);
				response.sendRedirect("/cft-web/CarreraController?accion=listar");
			} catch(SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
	}
	
	

	public Connection getConexion() throws NamingException, SQLException {
		InitialContext contextoInicial = new InitialContext();
		DataSource dataSource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/postgres");
		return dataSource.getConnection();
	}
	
	public void editarCarrera(Carrera carrera) throws SQLException, NamingException {
		String sql = "UPDATE carreras SET nombre = ? WHERE id = ?";
		try (
				Connection conexion = getConexion();
				//declaracion preparadas para evitar inyecciones de codigo sql(SEGFURIDAD)
				PreparedStatement declaracion = conexion.prepareStatement(sql);
				){
			declaracion.setString(1, carrera.getNombre());
			declaracion.setInt(2, carrera.getId());
			declaracion.executeUpdate();
		}
	}
	
	
	public void crearCarrera(Carrera carrera) throws SQLException, NamingException {
		String sql = "INSERT INTO carreras (nombre) VALUES(?)";
		try(
			Connection conexion = getConexion();
			PreparedStatement declaracion = conexion.prepareStatement(sql);
		){
			declaracion.setString(1, carrera.getNombre());
			int filasInsertadas = declaracion.executeUpdate();
		}
		
	}


	public List<Carrera> getCarreras() throws SQLException, NamingException {
		String sql = "SELECT * FROM carreras";
		try(
			Connection conexion = getConexion();
			Statement declaracion = conexion.createStatement();
		){
			ResultSet rs = declaracion.executeQuery(sql);
			List<Carrera> carreras = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Carrera carrera = new Carrera(id, nombre);
				carreras.add(carrera);
			}
			return carreras;
		}
	}


}
