package cr.com.aluraHotel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Statement;

import cr.com.aluraHotel.connectionFactory.conectionFactory;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.model.Reserva;

public class ReservasDAO {
	
	
	
	public ReservasDAO() {
		
	}
	
	public void guardarReservas(Reserva reserva) {
		final Connection con = new conectionFactory().reConnection();
		try(con){
			final PreparedStatement statement = con.prepareStatement("INSERT INTO reservas(fechaCheckIn, fechaCheckOut, dias, monto, metodoDePago)"
					+ "VALUES(?, ?, ?, ?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			try(statement){
				contructFile(reserva, statement);
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private void contructFile(Reserva reserva, PreparedStatement statement) {
		// TODO Auto-generated method stub
		try {
			statement.setString(1, reserva.getFechaCheckIn());
			statement.setString(2, reserva.getFechaCheckOut());
			statement.setInt(3, reserva.getDias());
			statement.setInt(4, reserva.getMonto());
			statement.setString(5, reserva.getMetodoDePago());
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			try(resultSet){
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1));
					ReservasController.setUltimoProductoRegistrado(resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public void modificarReserva(Integer id, String fechaCheckIn, String fechaCheckOut, Integer dias, Integer monto, String metodoDePago) {
		final Connection con = new conectionFactory().reConnection();
		
		try(con){
			PreparedStatement statement = con.prepareStatement("UPDATE reservas SET "
					+ "fechaCheckIn = ?, "
					+ "fechaCheckOut = ?, "
					+ "dias = ?, "
					+ "monto = ?, "
					+ "metodoDePago = ? "
					+ "WHERE ID = ?");
			try(statement){
				statement.setString(1, fechaCheckIn);
				statement.setString(2, fechaCheckOut);
				statement.setInt(3, dias);
				statement.setInt(4, monto);
				statement.setString(5, metodoDePago);
				statement.setInt(6, id);
				if(statement.execute()) JOptionPane.showMessageDialog(null, "Error al guardar reserva intenta de nuevo");
				else JOptionPane.showMessageDialog(null, "Reserva modificada perfectamente");	
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	

	
	public List<Reserva> listarReservas(){
		List<Reserva> resultado = new ArrayList<>();
		final Connection con = new conectionFactory().reConnection();
		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM reservas", java.sql.Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					Reserva reserva = new Reserva(
							resultSet.getInt("id"), 
							resultSet.getString("fechaCheckIn"), 
							resultSet.getString("fechaCheckOut"), 
							resultSet.getInt("dias"), 
							resultSet.getInt("monto"),
							resultSet.getString("metodoDePago"));
					resultado.add(reserva);		
				}
				return resultado;
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> listarBusqueda(String regex, String celda) {
		Connection con = new conectionFactory().reConnection();
		List<Reserva> resultado = new ArrayList<>();
		try(con){
			PreparedStatement statement = con.prepareStatement("SELECT * FROM reservas WHERE " + celda + " LIKE '" + regex + "%'");
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					Reserva reserva = new Reserva(
							resultSet.getInt("id"), 
							resultSet.getString("fechaCheckIn"), 
							resultSet.getString("fechaCheckOut"), 
							resultSet.getInt("dias"), 
							resultSet.getInt("monto"),
							resultSet.getString("metodoDePago"));
					resultado.add(reserva);		
				}
				return resultado;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}
	
	public void elliminar(int id) throws RuntimeException{
		final Connection con = new conectionFactory().reConnection();
		try(con){
			PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
			try(statement){
				statement.setInt(1, id);
				try {
					statement.execute();
				} catch (SQLIntegrityConstraintViolationException e) {
					// TODO: handle exception
					throw new RuntimeException(e);
				}
				

			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
