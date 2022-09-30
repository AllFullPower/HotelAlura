package cr.com.aluraHotel.windows;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cr.com.aluraHotel.DAO.ClienteDAO;
import cr.com.aluraHotel.DAO.ReservasDAO;
import cr.com.aluraHotel.JPanels.TablaClientes;
import cr.com.aluraHotel.controller.NacionalidadNumeroController;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.controller.ValidarInputsController;
import cr.com.aluraHotel.model.Cliente;
import cr.com.aluraHotel.model.Reserva;
import cr.com.aluraHotel.model.RoundBorder;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.InputMethodListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;

public class JFrameEditarCliente extends JFrame {

	private JPanel contentPane, upToolBar;
	private JLabel lblExitIcon;
	private JPanel btnExit;
	private JLabel lblSistemaDeReservasBackground;
	private JPanel panellLoginBackGround;
	private JLabel lblNewLabel;
	private JPanel panelnputsContainer;
	private JDateChooser chooserFechaDeNacimiento;
	private JComboBox comboBoxMetodoDePago;
	private JFormattedTextField inputNombre;
	private JLabel lblInputNombre;
	private JSeparator separatorNombre;
	private JFormattedTextField inputApellido;
	private JLabel lblApellido;
	private JSeparator separatorApellido;
	private JFormattedTextField inputTelefono;
	private JLabel lblNewLabel_3;
	private JSeparator separatorTelefono;
	private JTextArea textAreaNumeroDeReserva;
	private JLabel lblNumeroDeReserva;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblNacionalidad;
	private JLabel lblApellidoDelCliente;
	private JLabel lblTelDelCliente;
	private JLabel lblNombreUnfocus;
	private JPanel btnSaveReservaCliente;
	private JLabel lblSave;

	private ClienteDAO clienteDAO;
	
	private ReservasController reservasController;
	private TablaClientes tablaClientes;
	private ValidarInputsController inputsController;
	private NacionalidadNumeroController numeroController;
	
	private int mouseX, mouseY;
	private int numeroDeReservaComponent;
	private JPanel panelBackgroundContainer;
	private List<JDateChooser> listaChoosers = new ArrayList<>();
	private List<JFormattedTextField> listaInputs = new ArrayList<>();
	


	/**
	 * Create the frame.
	 */
	public JFrameEditarCliente(TablaClientes tablaClientes) {
		
		this.numeroController = new NacionalidadNumeroController();
		this.reservasController = new ReservasController();
		this.inputsController = new ValidarInputsController();
		
		this.tablaClientes = tablaClientes;
		this.clienteDAO = new ClienteDAO();
		
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//Contruir Escena
		constructorEscena();
		
	
	}
	
	public void setIcon(JLabel label, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
	}
	public void constructorEscena() {
		
		
		upToolBar = new JPanel();
		upToolBar.setOpaque(false);
		upToolBar.setBackground(Color.WHITE);
		upToolBar.setBounds(0, 0, 734, 28);
		contentPane.add(upToolBar);
		upToolBar.setLayout(null);
		
		btnExit = new JPanel();
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setOpaque(false);
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(700, 0, 34, 28);
		upToolBar.add(btnExit);
		btnExit.setLayout(null);
		
		lblExitIcon = new JLabel("     X");
		lblExitIcon.setBounds(0, 0, 34, 27);
		btnExit.add(lblExitIcon);
		
		panellLoginBackGround = new JPanel();
		panellLoginBackGround.setBackground(Color.WHITE);
		panellLoginBackGround.setBounds(403, 0, 331, 559);
		contentPane.add(panellLoginBackGround);
		panellLoginBackGround.setLayout(null);
		

		
		lblNewLabel = new JLabel("Editar Cliente");
		lblNewLabel.setBounds(87, 11, 194, 55);
		panellLoginBackGround.add(lblNewLabel);
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(96, 175, 219));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 25));
		
		panelnputsContainer = new JPanel();
		panelnputsContainer.setBorder(UIManager.getBorder("Button.border"));
		panelnputsContainer.setBackground(Color.WHITE);
		panelnputsContainer.setBounds(10, 55, 311, 454);
		panellLoginBackGround.add(panelnputsContainer);


		
		
		
		panelBackgroundContainer = new JPanel();
		panelBackgroundContainer.setOpaque(false);
		panelBackgroundContainer.setBackground(new Color(192, 192, 192));
		panelBackgroundContainer.setBounds(0, 0, 405, 559);
		contentPane.add(panelBackgroundContainer);
		panelBackgroundContainer.setLayout(null);
	
		lblSistemaDeReservasBackground = new JLabel("");
		lblSistemaDeReservasBackground.setOpaque(true);
		lblSistemaDeReservasBackground.setBounds(0, 0, 405, 559);
		panelBackgroundContainer.add(lblSistemaDeReservasBackground);
		setIcon(lblSistemaDeReservasBackground, ".\\images\\backgrounds\\SistemaDeReservasClienteBg.png");
		panelnputsContainer.setLayout(null);
		
		chooserFechaDeNacimiento = new JDateChooser();
		chooserFechaDeNacimiento.setBackground(Color.LIGHT_GRAY);
		chooserFechaDeNacimiento.setBounds(42, 167, 227, 20);
		panelnputsContainer.add(chooserFechaDeNacimiento);
		
		comboBoxMetodoDePago = new JComboBox();
		comboBoxMetodoDePago.setModel(new DefaultComboBoxModel(numeroController.leerArchivoNacionalidad()));
		comboBoxMetodoDePago.setBounds(42, 225, 227, 30);
		panelnputsContainer.add(comboBoxMetodoDePago);
		
		btnSaveReservaCliente = new JPanel();
		btnSaveReservaCliente.setLayout(null);
		btnSaveReservaCliente.setBackground(new Color(244, 186, 51));
		btnSaveReservaCliente.setBounds(215, 413, 86, 30);
		panelnputsContainer.add(btnSaveReservaCliente);
		
		lblSave = new JLabel("Save");
		lblSave.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblSave.setBounds(22, 8, 54, 14);
		btnSaveReservaCliente.add(lblSave);
		
		inputNombre = new JFormattedTextField();
		inputNombre.setToolTipText("");
		inputNombre.setSelectionColor(new Color(183, 222, 255));
		inputNombre.setOpaque(false);
		inputNombre.setName("UserInput");
		inputNombre.setForeground(Color.DARK_GRAY);
		inputNombre.setBorder(null);
		inputNombre.setBackground(new Color(64, 0, 64));
		inputNombre.setBounds(42, 49, 227, 20);
		panelnputsContainer.add(inputNombre);
		
		lblInputNombre = new JLabel("Nombre:");
		lblInputNombre.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblInputNombre.setBounds(42, 31, 227, 18);
		panelnputsContainer.add(lblInputNombre);
		
		separatorNombre = new JSeparator();
		separatorNombre.setBackground(Color.BLACK);
		separatorNombre.setBounds(42, 67, 227, 2);
		panelnputsContainer.add(separatorNombre);
		
		inputApellido = new JFormattedTextField();
		inputApellido.setToolTipText("");
		inputApellido.setSelectionColor(new Color(183, 222, 255));
		inputApellido.setOpaque(false);
		inputApellido.setName("UserInput");
		inputApellido.setForeground(Color.DARK_GRAY);
		inputApellido.setBorder(null);
		inputApellido.setBackground(new Color(64, 0, 64));
		inputApellido.setBounds(42, 98, 227, 20);
		panelnputsContainer.add(inputApellido);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblApellido.setBounds(42, 80, 227, 18);
		panelnputsContainer.add(lblApellido);
		
		separatorApellido = new JSeparator();
		separatorApellido.setBackground(Color.BLACK);
		separatorApellido.setBounds(42, 116, 227, 2);
		panelnputsContainer.add(separatorApellido);
		
		inputTelefono = new JFormattedTextField();
		inputTelefono.setToolTipText("");
		inputTelefono.setSelectionColor(new Color(183, 222, 255));
		inputTelefono.setOpaque(false);
		inputTelefono.setName("UserInput");
		inputTelefono.setForeground(Color.DARK_GRAY);
		inputTelefono.setBorder(null);
		inputTelefono.setBackground(new Color(64, 0, 64));
		inputTelefono.setBounds(43, 292, 227, 20);
		panelnputsContainer.add(inputTelefono);
		
		lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(43, 274, 227, 18);
		panelnputsContainer.add(lblNewLabel_3);
		
		separatorTelefono = new JSeparator();
		separatorTelefono.setBackground(Color.BLACK);
		separatorTelefono.setBounds(43, 310, 227, 2);
		panelnputsContainer.add(separatorTelefono);
		
		textAreaNumeroDeReserva = new JTextArea();
		textAreaNumeroDeReserva.setEditable(false);
		textAreaNumeroDeReserva.setBackground(Color.LIGHT_GRAY);
		textAreaNumeroDeReserva.setBounds(42, 359, 227, 22);
		panelnputsContainer.add(textAreaNumeroDeReserva);
		
		lblNumeroDeReserva = new JLabel("Numero de reserva:");
		lblNumeroDeReserva.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNumeroDeReserva.setBounds(42, 331, 227, 18);
		panelnputsContainer.add(lblNumeroDeReserva);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblFechaDeNacimiento.setBounds(42, 138, 227, 18);
		panelnputsContainer.add(lblFechaDeNacimiento);
		
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNacionalidad.setBounds(42, 198, 227, 18);
		lblNacionalidad.setVisible(false);
		panelnputsContainer.add(lblNacionalidad);
		
		lblNombreUnfocus = new JLabel("Nombre del cliente");
		lblNombreUnfocus.setForeground(Color.LIGHT_GRAY);
		lblNombreUnfocus.setBounds(42, 52, 227, 14);
		lblNombreUnfocus.setVisible(false);
		panelnputsContainer.add(lblNombreUnfocus);
		
		lblApellidoDelCliente = new JLabel("Apellido del cliente");
		lblApellidoDelCliente.setForeground(Color.LIGHT_GRAY);
		lblApellidoDelCliente.setBounds(42, 101, 227, 14);
		lblApellidoDelCliente.setVisible(false);
		panelnputsContainer.add(lblApellidoDelCliente);
		
		lblTelDelCliente = new JLabel("Tel del Cliente: +XXX  XXXX-XXXX");
		lblTelDelCliente.setForeground(Color.LIGHT_GRAY);
		lblTelDelCliente.setBounds(42, 295, 227, 14);
		lblTelDelCliente.setVisible(false);
		panelnputsContainer.add(lblTelDelCliente);
		
		listaChoosers.add(chooserFechaDeNacimiento);
		listaInputs.add(inputApellido);
		listaInputs.add(inputNombre);
		listaInputs.add(inputTelefono);
		
		llenarInfo();
		

		//-----------------------EVETNS LISTENERS
		
		upToolBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
		});
		
		upToolBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
				
			}
		});
		
		//------------BOTON EXIT
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setOpaque(true);
				lblExitIcon.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setOpaque(false);
				lblExitIcon.setForeground(new Color(0, 0, 0));

			
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres salir, no se guardaran los datos modificados?") == 0) dispose();
			}
		});
		
		btnSaveReservaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!inputsController.validarTxt(listaInputs) || !inputsController.validarDates(listaChoosers)){JOptionPane.showMessageDialog(null, "No puedes dejar informacion en blanco"); return;}

				int posicion = tablaClientes.getUltimoClientePosicion();
					
				Date date = chooserFechaDeNacimiento.getDate();
				//DATA
				String nombre = String.valueOf(inputNombre.getText());
				String apellido = String.valueOf(inputApellido.getText());
				String fechaDeNacimiento = construcDate(date);
				String nacionalidad = String.valueOf(comboBoxMetodoDePago.getSelectedItem());
				String numero = String.valueOf(inputTelefono.getText()); 	
				clienteDAO.modificar((Integer) tablaClientes.getTable().getValueAt(posicion, 0), nombre, apellido, fechaDeNacimiento, nacionalidad, numero);
		
				//Actualizando tabla
				tablaClientes.getTable().setValueAt(nombre, posicion, 1);
				tablaClientes.getTable().setValueAt(apellido, posicion, 2);
				tablaClientes.getTable().setValueAt(fechaDeNacimiento, posicion, 3);
				tablaClientes.getTable().setValueAt(nacionalidad, posicion, 4);
				tablaClientes.getTable().setValueAt("(+" + numeroController.getNumero(nacionalidad)+ ")" + numero, posicion, 5);
				tablaClientes.getTable().repaint();
				tablaClientes.setUltimoClientePosicion(0);
					
				JOptionPane.showMessageDialog(null, "Cliente modificado perfectamente");
				dispose();
	}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSave.setForeground(Color.WHITE);
				btnSaveReservaCliente.setBackground(new Color(223, 160, 13));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSave.setForeground(Color.BLACK);
				btnSaveReservaCliente.setBackground(new Color(244, 186, 51));
			}
		});
		
		//-----------INPUTS ANIMATIONS
		
		
		inputAnimation(inputNombre, separatorNombre, lblNombreUnfocus);
		inputAnimation(inputApellido, separatorApellido, lblApellidoDelCliente);
		inputAnimation(inputTelefono, separatorTelefono, lblTelDelCliente);
		

		
	}
	
	public void llenarInfo() {
		Cliente cliente = tablaClientes.getUltimoCliente();
		
		char mas = 	43;
		
		String nacionalidadNumero = "\\(" + "\\+" + numeroController.getNumero(cliente.getNacionalidad()) + "\\)";

		
		inputNombre.setText(cliente.getNombre());
		inputApellido.setText(cliente.getApellido());
		chooserFechaDeNacimiento.setDate(reConstructDate(cliente.getFechaNacimiento()));
		comboBoxMetodoDePago.setSelectedItem(cliente.getNacionalidad());
		inputTelefono.setText(cliente.getNumeroTelefonico().replaceAll(nacionalidadNumero, ""));
		textAreaNumeroDeReserva.setText(String.valueOf(cliente.getReservaId()).toString());
		
	}
	
	private Date reConstructDate(String date) {
		Date result;
		String[] dateReserva = date.toString().split("/");
		String dateCompresion = dateReserva[1] + "/" + dateReserva[0] + "/" + dateReserva[2];
		result = new Date(dateCompresion);
		return result;
	}
	
	public JTextArea getTxtANumeroReserva() {
		return this.textAreaNumeroDeReserva;
	}
	
	
	
	public void inputAnimation(final JFormattedTextField input, final JSeparator separador, final JLabel text) {
		input.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				text.setVisible(false);
				separador.setBackground(Color.CYAN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				separador.setBackground(Color.BLACK);
				boolean noEscribio = input.getText().isEmpty();
				if(noEscribio) {
					text.setVisible(true);
				}

			}
		});
	}
	
	private String construcDate(Date date) {
		String day = String.valueOf(date.getDate());
		String month = String.valueOf(date.getMonth() + 1);
		System.out.println(String.valueOf(date.getYear()));
		String year = calcYear(date.getYear());
		String checkDate = day + "/" + month + "/" + year;
		
		return checkDate;
		
	}
	
	private String calcYear(int year) {
		String result = String.valueOf(year);
		if(year >= 110) {
			result = String.valueOf(year - 100); 
		}else if(year < 110 && year > 99) {
			result = "0" + String.valueOf(year-100);
		}else if(year == 100) {
			result = "2000";
		}
		return result;
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
