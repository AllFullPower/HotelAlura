package cr.com.aluraHotel.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import cr.com.aluraHotel.model.Usuario;

public class IniciarSesionController {
	private DataUsuariosController dataUserController;
	private boolean resultado;
	 
	
	public IniciarSesionController() {
		this.dataUserController = new  DataUsuariosController();
	}

	public boolean validarUsuario(String userName, String contrasena) {
		try {
			Optional<Usuario> userIniciado = dataUserController.getRegistroUsuarios().stream().filter(user -> (user.getContrasena().equals(contrasena)) && user.getUser().equals(userName)).findAny();
			System.out.println(userIniciado.empty());
			System.out.println("Usuario: " + userIniciado.get().getUser() + " " + userIniciado.get().getContrasena());
			userIniciado.get().setSesionIniciada(true);
			resultado = userIniciado.isPresent();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No encontramos ningun usuario, porfavor intenta de nuevo");
			resultado = false;
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public void cerrarSesionUser() {
		Optional<Usuario> usuarioIniciado = dataUserController.getRegistroUsuarios().stream().filter(user -> user.getSesionIniciada() == true).findAny();
		usuarioIniciado.get().setSesionIniciada(false);
	}
	
}
