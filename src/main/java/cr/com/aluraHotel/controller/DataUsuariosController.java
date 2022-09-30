package cr.com.aluraHotel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cr.com.aluraHotel.model.Usuario;

public class DataUsuariosController{
	private static List<Usuario> registroUsuarios =  new ArrayList<>();
	
	public void agregarUsuario(Usuario user) {
		registroUsuarios.add(user);
	}
	
	public List<Usuario> getRegistroUsuarios(){
		return DataUsuariosController.registroUsuarios;
	}
	

}
