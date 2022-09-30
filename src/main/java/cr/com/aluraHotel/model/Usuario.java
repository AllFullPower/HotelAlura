package cr.com.aluraHotel.model;

public class Usuario {
	private String nombre;
	private String contrasena;
	private boolean sesionIniciada;
	private static int id;
		
	public Usuario(String nombre, String contrasena) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.sesionIniciada = false;
		id++;
	}
	
	public String getUser() {
		return this.nombre;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
	
	public void setSesionIniciada(boolean status) {
		this.sesionIniciada = status;
	}
	
	public boolean getSesionIniciada() {
		return this.sesionIniciada;
	}
}
