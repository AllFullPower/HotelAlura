package cr.com.aluraHotel.model;

public class Cliente {
	private int id;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String nacionalidad;
	private String numeroTelefonico;
	private int reservaid;
	
	public Cliente(String nombre, String apellido, String fechaNacimiento, String nacionalidad, String numeroTelefonico) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.numeroTelefonico = numeroTelefonico;
	}
	
	public Cliente(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String numeroTelefonico) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.numeroTelefonico = numeroTelefonico;
		this.id = id;
	}
	
	public Cliente(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String numeroTelefonico, Integer reservaId) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.numeroTelefonico = numeroTelefonico;
		this.id = id;
		this.reservaid = reservaId;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	
	public String getNumeroTelefonico() {
		return this.numeroTelefonico;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Integer getReservaId() {
		return this.reservaid;
	}
	
	public void setReservaId(Integer id) {
		this.reservaid = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String resultado = this.id + " " + this.nombre + " " + this.apellido + " " + this.fechaNacimiento + " " + this.nacionalidad;
		return resultado;
	}
	
	
}
