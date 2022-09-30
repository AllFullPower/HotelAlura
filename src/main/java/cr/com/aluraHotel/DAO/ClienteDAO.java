package cr.com.aluraHotel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cr.com.aluraHotel.connectionFactory.conectionFactory;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.model.Cliente;

public class ClienteDAO {
	
	
	public ClienteDAO(){
		
	}
	
	public void agregarCliente(Cliente cliente) {
		final Connection con = new conectionFactory().reConnection();
		try(con){
			PreparedStatement statement = con.prepareStatement("INSERT INTO Cliente"
					+ "(nombre, apellido, fechaDeNacimiento, nacionalidad, numeroTelefonico, reserva_id)"
					+ "VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			try(statement){
				contrucCliente(statement, cliente);
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private void contrucCliente(PreparedStatement statement, Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellido());
			statement.setString(3, cliente.getFechaNacimiento());
			statement.setString(4, cliente.getNacionalidad());
			statement.setString(5, cliente.getNumeroTelefonico());
			statement.setInt(6, ReservasController.getUltimoElementoRegistradoId());
			if(statement.execute()) JOptionPane.showMessageDialog(null, "Error al guardar cliente intenta de nuevo"); 
			else JOptionPane.showInternalMessageDialog(null, "Cliente guardado perfectamente");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> listarCliente(){
		final Connection con = new conectionFactory().reConnection();
		List<Cliente> resultado = new ArrayList<>();
		try(con){
			PreparedStatement statement = con.prepareStatement("select * from cliente");
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					Cliente cliente = new Cliente(
							resultSet.getInt("ID"), 
							resultSet.getString("nombre"), 
							resultSet.getString("apellido"), 
							resultSet.getString("fechaDeNacimiento"), 
							resultSet.getString("nacionalidad"), 
							resultSet.getString("numeroTelefonico"));
							cliente.setReservaId(resultSet.getInt("reserva_id"));
					resultado.add(cliente);
				}
				return resultado;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void eliminar(int id) {
		final Connection con = new conectionFactory().reConnection();
		try(con){
			PreparedStatement statement = con.prepareStatement("DELETE FROM cliente WHERE ID = ?");
			try(statement){
				statement.setInt(1, id);
				statement.execute();
			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> listarBusqueda(String regex, String tipo){
		Connection con = new conectionFactory().reConnection();
		List<Cliente> resultado = new ArrayList();
		try(con){
			PreparedStatement statement = con.prepareStatement("SELECT * FROM cliente WHERE " + tipo + " LIKE '" + regex + "%'");
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					Cliente cliente = new Cliente(
							resultSet.getInt("id"), 
							resultSet.getString("nombre"), 
							resultSet.getString("apellido"), 
							resultSet.getString("fechaDeNacimiento"), 
							resultSet.getString("nacionalidad"), 
							resultSet.getString("numeroTelefonico"),
							resultSet.getInt("reserva_id"));
					resultado.add(cliente);
				}
				return resultado;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void modificar(Integer id ,String nombre, String apellido, String fechaDeNacimiento, String nacionalidad,
			String numero){
		final Connection con = new conectionFactory().reConnection();
		try(con){
			PreparedStatement statement = con.prepareStatement("UPDATE cliente SET"
					+ " nombre = ?,"
					+ " apellido = ?,"
					+ " fechaDeNacimiento = ?,"
					+ " nacionalidad = ?,"
					+ " numeroTelefonico = ?"
					+ " WHERE ID = ?");
			try(statement){
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setString(3, fechaDeNacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, numero);
				statement.setInt(6, id);
				statement.execute();
			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
}
