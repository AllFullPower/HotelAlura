package cr.com.aluraHotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import cr.com.aluraHotel.model.Reserva;

public class ReservasController {
	static Integer ultimoProductoRegistrado;
	

	
	public ReservasController() {
		
	}
	
	public static void setUltimoProductoRegistrado(Integer id) {
		ReservasController.ultimoProductoRegistrado = id;
	}
	public static int getUltimoElementoRegistradoId() {
		return ReservasController.ultimoProductoRegistrado;
	}
		

}
