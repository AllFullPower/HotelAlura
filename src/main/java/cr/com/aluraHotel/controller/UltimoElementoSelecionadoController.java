package cr.com.aluraHotel.controller;

public class UltimoElementoSelecionadoController {
	private  static Object utlimoElemento;
	private static int posicion;
	
	public static void setUltimoElemento(Object elemento) {
		UltimoElementoSelecionadoController.utlimoElemento = elemento;
	}
	
	public static Object getUltimoElemento() {
		return UltimoElementoSelecionadoController.utlimoElemento;
	}
	
	public static void setPosicion(int posicion) {
		UltimoElementoSelecionadoController.posicion = posicion;
	}
	
	public static int getPosicion() {
		return UltimoElementoSelecionadoController.posicion;
	}
}
