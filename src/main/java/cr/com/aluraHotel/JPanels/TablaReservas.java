package cr.com.aluraHotel.JPanels;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cr.com.aluraHotel.DAO.ReservasDAO;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.controller.UltimoElementoSelecionadoController;
import cr.com.aluraHotel.model.Reserva;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TablaReservas extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private ReservasDAO reservasDAO;
	
	private int ultimaReservaPosicion = -5;
	private Reserva ultimaReserva;

	/**
	 * Create the panel.
	 */
	public TablaReservas() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		reservasDAO = new ReservasDAO();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 856, 351);
		add(scrollPane);
		
		model = new DefaultTableModel();
		table = new JTable();
		table.setGridColor(new Color(253, 232, 232));
		table.setForeground(new Color(84, 7, 7));
		table.setBackground(new Color(247, 134, 134));
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selecionado = table.rowAtPoint(e.getPoint());
				ultimaReservaPosicion = selecionado;
				Reserva reserva = new Reserva(
						Integer.parseInt(table.getValueAt(selecionado, 0).toString()) 
						, String.valueOf(table.getValueAt(selecionado, 1))
						, String.valueOf(table.getValueAt(selecionado, 2))
						, Integer.parseInt(table.getValueAt(selecionado, 3).toString()) 
						, Integer.parseInt(table.getValueAt(selecionado, 4).toString().replace("$", "")) 
						, String.valueOf(table.getValueAt(selecionado, 5)));
				System.out.println(reserva);
				ultimaReserva = reserva;
				
			}
		});
		table.setModel(model);
	
		
		model.addColumn("ID");
		model.addColumn("FechaCheckIn");
		model.addColumn("FechaCheckOut");
		model.addColumn("Dias");
		model.addColumn("Monto");
		model.addColumn("MetodoDePago");
		llenarTabla();

		scrollPane.setViewportView(table);

	}
	
	public void buscarReserva(String regex, String celda) {
		List<Reserva> reservas = reservasDAO.listarBusqueda(regex, celda);
		System.out.println(reservas);
		reservas.forEach(reserva ->{
			Object[] fila = new Object[6];
			fila[0] = reserva.getId();
			fila[1] = reserva.getFechaCheckIn();
			fila[2] = reserva.getFechaCheckOut();
			fila[3] = reserva.getDias();
			fila[4] = "$" + reserva.getMonto();
			fila[5] = reserva.getMetodoDePago();
			model.addRow(fila);
		});;
	
		
	}
	
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) table.getModel();
		
		int fila = table.getRowCount();
		System.out.println(fila);
		for(int i = 0; i < fila; i++) {
			modelo.removeRow(0);
		}
	}
	public void setUltimaReservaPosicion(int posicion) {
		this.ultimaReservaPosicion = posicion;
	}
	
	public int getUltimaReservaPosicion() {
		return this.ultimaReservaPosicion;
	}
	
	public Reserva getUltimaReserva() {
		return this.ultimaReserva;
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	
	public void eliminar(int id) {
		model.removeRow(id);
	}
	
	public void llenarTabla() {
		
		List<Reserva> reservas = reservasDAO.listarReservas();
		reservas.forEach(reserva ->{
			Object[] fila = new Object[6];
			fila[0] = reserva.getId();
			fila[1] = reserva.getFechaCheckIn();
			fila[2] = reserva.getFechaCheckOut();
			fila[3] = reserva.getDias();
			fila[4] = "$" + reserva.getMonto();
			fila[5] = reserva.getMetodoDePago();
			model.addRow(fila);
		});;
	}

}
