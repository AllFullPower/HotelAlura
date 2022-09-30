package cr.com.aluraHotel.model;

public class Reserva {
	private Integer id;
	private String fechaCheckIn;
	private String fechaCheckOut;
	private int dias;
	private int monto;
	private String metodoDePago;
	
	private static Integer ultimoProductoRegistrado;
	
	public Reserva(String fechaCheckIn, String fechaCheckOut, int dias, int monto, String metodoDePago) {
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.dias = dias;
		this.monto = monto;
		this.metodoDePago = metodoDePago;
	}
	
	public Reserva(int id, String fechaCheckIn, String fechaCheckOut, int dias, int monto, String metodoDePago) {
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.dias = dias;
		this.monto = monto;		
		this.id = id;
		this.metodoDePago = metodoDePago;
	}
	
	
	public String getFechaCheckIn() {
		return this.fechaCheckIn;
	}
	
	public String getFechaCheckOut() {
		return this.fechaCheckOut;
	}
	
	public int getDias() {
		return this.dias;
	}
	
	public int getMonto() {
		return this.monto;
	}
	
	public String getMetodoDePago() {
		return this.metodoDePago;
	}
	
	public Integer getId() {
		return this.id;
	}
	

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String reservaDesglosada = "Id: " + this.id + " CheckIn: " + this.fechaCheckIn + " CheckOut " 
		+ this.fechaCheckOut + " Dias: " + this.dias + " Monto: " + this.monto + " Pago: " + this.metodoDePago;
		return reservaDesglosada;
	}
}
