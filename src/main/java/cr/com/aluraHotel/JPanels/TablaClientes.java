package cr.com.aluraHotel.JPanels;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cr.com.aluraHotel.DAO.ClienteDAO;
import cr.com.aluraHotel.DAO.ReservasDAO;
import cr.com.aluraHotel.controller.NacionalidadNumeroController;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.controller.UltimoElementoSelecionadoController;
import cr.com.aluraHotel.model.Cliente;
import cr.com.aluraHotel.model.Reserva;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TablaClientes extends JPanel {
	private DefaultTableModel model;
	private ClienteDAO clienteDAO;
	private JTable table;
	private Cliente ultimoCliente;
	private Integer ultimoClientePosicion = - 5;
	private NacionalidadNumeroController numeroController;

	/**
	 * Create the panel.
	 */
	public TablaClientes() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		clienteDAO = new ClienteDAO();
		numeroController = new NacionalidadNumeroController();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 856, 351);
		add(scrollPane);
		table = new JTable();
		table.setForeground(new Color(0, 63, 66));
		table.setGridColor(new Color(214, 232, 233));
		table.setBackground(new Color(160, 200, 203));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selecionado = table.rowAtPoint(e.getPoint());
				ultimoClientePosicion = selecionado;
				UltimoElementoSelecionadoController.setPosicion(selecionado);
				Cliente cliente = new Cliente(
						Integer.valueOf(table.getValueAt(selecionado, 0).toString())
						, String.valueOf(table.getValueAt(selecionado, 1))
						, String.valueOf(table.getValueAt(selecionado, 2))
						, String.valueOf(table.getValueAt(selecionado, 3))
						, String.valueOf(table.getValueAt(selecionado, 4))
						, String.valueOf(table.getValueAt(selecionado, 5))
						, Integer.parseInt(table.getValueAt(selecionado, 6).toString()));
				System.out.println(cliente);
				ultimoCliente = cliente;
			}
		});
		model = new DefaultTableModel();
		table.setModel(model);
		
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha de Nacimiento");
		model.addColumn("Nacionalidad");
		model.addColumn("Numero");
		model.addColumn("Reserva_id");
		scrollPane.setViewportView(table);
		

	}
	
	
	public JTable getTable() {
		return this.table;
	}
	
	public Cliente getUltimoCliente() {
		return this.ultimoCliente;
	}
	
	public int getUltimoClientePosicion() {
		return this.ultimoClientePosicion;
	}
	
	public void setUltimoClientePosicion(int posicion) {
		this.ultimoClientePosicion = posicion;
	}
	
	public void buscarCliente(String regex, String celda) {
		List<Cliente> clientes = clienteDAO.listarBusqueda(regex, celda);

		System.out.println(clientes);
		clientes.forEach(cliente ->{
			String numeroPais = "(+"+numeroController.getNumero(cliente.getNacionalidad()) + ")";
			Object[] fila = new Object[7];
			fila[0] = cliente.getId();
			fila[1] = cliente.getNombre();
			fila[2] = cliente.getApellido();
			fila[3] = cliente.getFechaNacimiento();
			fila[4] = cliente.getNacionalidad();
			fila[5] = numeroPais + cliente.getNumeroTelefonico();
			fila[6] = cliente.getReservaId();
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
	
	public void eliminar(int posicion) {
		model.removeRow(posicion);
	}
	
	public void llenarTabla() {
			List<Cliente> clientes = clienteDAO.listarCliente();
			clientes.forEach(cliente ->{
				String numeroPais = "(+"+numeroController.getNumero(cliente.getNacionalidad()) + ")";
				Object[] fila = new Object[7];
				fila[0] = cliente.getId();
				fila[1] = cliente.getNombre();
				fila[2] = cliente.getApellido();
				fila[3] = cliente.getFechaNacimiento();
				fila[4] = cliente.getNacionalidad();
				fila[5] = numeroPais + cliente.getNumeroTelefonico();
				fila[6] = cliente.getReservaId();
				model.addRow(fila);
			});

	}

}
