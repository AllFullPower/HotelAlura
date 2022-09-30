package cr.com.aluraHotel.view;

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
import cr.com.aluraHotel.JPanels.TablaReservas;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.controller.UltimoElementoSelecionadoController;
import cr.com.aluraHotel.model.Cliente;
import cr.com.aluraHotel.model.Reserva;
import cr.com.aluraHotel.model.RoundBorder;
import cr.com.aluraHotel.windows.JFrameEditarCliente;
import cr.com.aluraHotel.windows.JFrameEditarReserva;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import java.sql.SQLIntegrityConstraintViolationException;
import java.beans.PropertyChangeEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFrameBusqueda extends JFrame {

	private JPanel contentPane, upToolBar;
	private JLabel lblExitIcon;
	private JPanel btnExit;
	private JFrameLogin JFrameLogin;
	private JFrameRegistrarReserva frameRegistrarReserva;
	
	private ReservasDAO reservasDAO;
	private ClienteDAO clienteDAO;
	
	private ReservasController reservasController;
	
	private int mouseX, mouseY;
	private int numeroDeReservaComponent;
	private JPanel panelContenedorDeTablas;
	private JPanel btnBack;
	private JLabel lblBtnBackLogo;
	private JPanel panelContenedorInputBusqueda;
	private JLabel lblTitulo;
	private JPanel btnReservas;
	private JPanel btnClientes;
	private JLabel lblReservasBtn;
	private JLabel lblClientesBtn;
	private JLabel aluraHotelIcon;
	private JTextPane textPaneBuscador;
	private TablaReservas tablaReservas;
	private TablaClientes tablaClientes;
	
	private Color btnCyan, btnGray, lblWhite, lblBlack;
	private JPanel panelBackGroundTable;
	private JPanel btnDelete;
	private JLabel lblBtnDeleteIcon;
	
	private static int tablaEnPantalla = 0;
	private int clickCount = 0;
	
	private JPanel btnBuscar;
	private JLabel lblBtnSearchIcon;
	private JComboBox comboBoxSelectorFila;
	private JPanel btnEditar;
	private JLabel lblBtnEditar;



	/**
	 * Create the frame.
	 */
	public JFrameBusqueda() {
		
		setUndecorated(true);
		this.reservasController = new ReservasController();
		this.reservasDAO = new ReservasDAO();
		this.clienteDAO = new ClienteDAO();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
	
		//Contruir Escena
		constructorEscena();
		
		//Cargar el login
		JFrameLogin = new JFrameLogin();
	}
	
	public void setIcon(JLabel label, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
	}
	public void constructorEscena() {
		tablaReservas = new TablaReservas();
		tablaClientes = new TablaClientes();
		tablaClientes.setVisible(false);
		
		btnGray = new Color(128, 128, 128);
		btnCyan = new Color(129, 209, 218);
		lblBlack = Color.BLACK;
		lblWhite = Color.WHITE;
		
		contentPane.setLayout(null);
		upToolBar = new JPanel();
		upToolBar.setBounds(0, 0, 876, 28);
		upToolBar.setBackground(new Color(92, 90, 91));
		contentPane.add(upToolBar);
		upToolBar.setLayout(null);
		
		btnExit = new JPanel();
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setBackground(new Color(92, 90, 91));
		btnExit.setBounds(842, 0, 34, 28);
		upToolBar.add(btnExit);
		btnExit.setLayout(null);
		
		lblExitIcon = new JLabel("X");
		lblExitIcon.setBounds(13, 0, 13, 27);
		btnExit.add(lblExitIcon);
		lblExitIcon.setForeground(Color.BLACK);
		
		
		tablaReservas.setBounds(0, 0, 856, 351);
		tablaClientes.setBounds(0, 0, 856, 351);
		panelContenedorDeTablas = new JPanel();
		panelContenedorDeTablas.setBounds(10, 172, 856, 351);
		panelContenedorDeTablas.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		panelContenedorDeTablas.setLayout(null);
		panelContenedorDeTablas.add(tablaReservas);
		panelContenedorDeTablas.add(tablaClientes);
		contentPane.add(panelContenedorDeTablas);
		
		panelContenedorInputBusqueda = new JPanel();
		panelContenedorInputBusqueda.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelContenedorInputBusqueda.setBounds(639, 111, 172, 35);
		panelContenedorInputBusqueda.setBackground(new Color(128, 128, 128));
		contentPane.add(panelContenedorInputBusqueda);
		panelContenedorInputBusqueda.setLayout(null);
		
		textPaneBuscador = new JTextPane();
		textPaneBuscador.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPaneBuscador.setBounds(5, 7, 161, 20);
		panelContenedorInputBusqueda.add(textPaneBuscador);
		
		lblTitulo = new JLabel("Registro De Reservas y Clientes");
		lblTitulo.setBounds(218, 39, 419, 35);
		lblTitulo.setForeground(new Color(81, 166, 198));
		lblTitulo.setBackground(new Color(50, 202, 228));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 28));
		contentPane.add(lblTitulo);
		
		btnReservas = new JPanel();
		btnReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnReservas.setBounds(20, 131, 106, 25);
		
		contentPane.add(btnReservas);
		btnReservas.setLayout(null);
		
		lblReservasBtn = new JLabel("Reservas");
		lblReservasBtn.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblReservasBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservasBtn.setBounds(0, 0, 105, 26);
		btnReservas.add(lblReservasBtn);
	
		btnClientes = new JPanel();
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnClientes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnClientes.setBounds(136, 131, 106, 25);
		btnClientes.setBackground(btnGray);
		btnClientes.setLayout(null);
		contentPane.add(btnClientes);
		
		lblClientesBtn = new JLabel("Clientes");
		lblClientesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientesBtn.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblClientesBtn.setBounds(8, 7, 86, 14);
		btnClientes.add(lblClientesBtn);
		
		aluraHotelIcon = new JLabel("");
		aluraHotelIcon.setBounds(0, 27, 126, 104);
		setIcon(aluraHotelIcon, ".\\images\\logos\\HotelLogo.png");
		contentPane.add(aluraHotelIcon);
		
		panelBackGroundTable = new JPanel();
		panelBackGroundTable.setBackground(new Color(87, 87, 87));
		panelBackGroundTable.setBounds(0, 154, 876, 405);
		panelBackGroundTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelBackGroundTable);
		panelBackGroundTable.setLayout(null);
		
		btnBack = new JPanel();
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBounds(6, 375, 32, 25);
		panelBackGroundTable.add(btnBack);
		btnBack.setBackground(new Color(138, 255, 255));
		btnBack.setLayout(null);
		
		lblBtnBackLogo = new JLabel("New label");
		lblBtnBackLogo.setBounds(6, 4, 19, 19);
		btnBack.add(lblBtnBackLogo);
		setIcon(lblBtnBackLogo, ".\\images\\logos\\OutLogo.png");
		
		btnDelete = new JPanel();
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setLayout(null);
		btnDelete.setBackground(new Color(255, 60, 60));
		btnDelete.setBounds(706, 375, 32, 25);
		panelBackGroundTable.add(btnDelete);
		
		lblBtnDeleteIcon = new JLabel("New label");
		lblBtnDeleteIcon.setBounds(9, 6, 14, 14);
		setIcon(lblBtnDeleteIcon, ".\\images\\logos\\DeleteLogo.png");
		btnDelete.add(lblBtnDeleteIcon);
		
		btnEditar = new JPanel();
		btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(255, 113, 45));
		btnEditar.setBounds(777, 375, 32, 25);
		panelBackGroundTable.add(btnEditar);
		
		lblBtnEditar = new JLabel("New label");
		lblBtnEditar.setBounds(9, 6, 14, 14);
		setIcon(lblBtnEditar, ".\\images\\logos\\EditLogo.png");
		btnEditar.add(lblBtnEditar);
		
		btnReservas.setBackground(btnColor(tablaReservas, btnCyan, btnGray));
		lblReservasBtn.setForeground((btnColor(tablaReservas, lblWhite, lblBlack)));
		
		btnBuscar = new JPanel();
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBackground(new Color(104, 174, 244));
		btnBuscar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBuscar.setBounds(821, 111, 34, 35);
		contentPane.add(btnBuscar);
		btnBuscar.setLayout(null);
		
		lblBtnSearchIcon = new JLabel("New label");
		lblBtnSearchIcon.setBounds(4, 4, 28, 28);
		setIcon(lblBtnSearchIcon, ".\\images\\logos\\btnSearchLogo.png");
		btnBuscar.add(lblBtnSearchIcon);
		
		comboBoxSelectorFila = new JComboBox();
		comboBoxSelectorFila.setModel(new DefaultComboBoxModel(new String[] {"id", "FechaCheckIn", "FechaCheckOut", "Dias", "Monto", "MetodoDePago"}));
		comboBoxSelectorFila.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBoxSelectorFila.setBounds(640, 91, 172, 22);
		contentPane.add(comboBoxSelectorFila);
				
		

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
				btnExit.setBackground(new Color(255, 0, 0));
				lblExitIcon.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(92, 90, 91));
				lblExitIcon.setForeground(new Color(0, 0, 0));

			
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?") == 0) System.exit(0);
			}
		});
		
		//--------------BTN RESERVAS
		btnReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReservas.setBackground(new Color(110, 110, 110));
				
	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReservas.setBackground(btnColor(tablaReservas, btnCyan, btnGray));
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxSelectorFila.setModel(new DefaultComboBoxModel(new String[] {"id", "FechaCheckIn", "FechaCheckOut", "Dias", "Monto", "MetodoDePago"}));
				tablaReservas.setVisible(true);
				tablaClientes.setVisible(false);
				tablaEnPantalla = 0;
				invertColors(lblReservasBtn, btnReservas, lblClientesBtn, btnClientes, btnCyan, btnGray, tablaReservas, tablaClientes);
				
			}
		});
		
		///-------------BTN CLIENTE
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClientes.setBackground(new Color(110, 110, 110));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClientes.setBackground(btnColor(tablaClientes, btnCyan, btnGray));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCount++;
				comboBoxSelectorFila.setModel(new DefaultComboBoxModel(new String[] {"id", "Nombre", "Apellido", "FechaDeNacimiento", "Nacionalidad", "NumeroTelefonico", "Reserva_id"}));
				if(clickCount == 1) tablaClientes.llenarTabla();
				tablaReservas.setVisible(false); 
				tablaClientes.setVisible(true); 
				tablaEnPantalla = 1;
				invertColors(lblReservasBtn, btnReservas, lblClientesBtn, btnClientes, btnCyan, btnGray, tablaReservas, tablaClientes);
				
			}
		});
		

	
		//---------BTN BACK
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(200,200,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground(new Color(138, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JFrameLogged frameLogged = new JFrameLogged();
				frameLogged.setLocationRelativeTo(null);
				frameLogged.setVisible(true);
				
			}
		});
		
		
		//-----------------BTN BUSCAR
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String inputTxt = String.valueOf(textPaneBuscador.getText());
				String fila = comboBoxSelectorFila.getSelectedItem().toString();
				System.out.println(tablaEnPantalla);
				if(tablaEnPantalla == 0) {
					tablaReservas.limpiarTabla();
					tablaReservas.buscarReserva(inputTxt, fila);	
				}else if(tablaEnPantalla == 1) {
					tablaClientes.limpiarTabla();
					tablaClientes.buscarCliente(inputTxt, fila);
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(183, 233, 249));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(104, 174, 244));
				
			}
		});
		
		
		
		
		//------------------BTN ELIMINAR
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tablaEnPantalla == 0) {
					if(tablaReservas.getUltimaReservaPosicion() == -5) {JOptionPane.showMessageDialog(null, "Seleciona un elemento para eliminar"); return;}
					Reserva reserva = tablaReservas.getUltimaReserva();
					
					//Atrapando la exepcion de la foreign key
					try {
						reservasDAO.elliminar(reserva.getId());
						tablaReservas.eliminar(tablaReservas.getUltimaReservaPosicion());
						tablaReservas.repaint();
					} catch (RuntimeException e2) {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar la reserva, sigue VINCULADA a un CLIENTE, borra el cliente primero");
					}

				}else if(tablaEnPantalla == 1) {
					if(tablaClientes.getUltimoClientePosicion() == -5) {JOptionPane.showMessageDialog(null, "Seleciona un elemento para eliminar"); return;}
					Cliente cliente = tablaClientes.getUltimoCliente();
					clienteDAO.eliminar(cliente.getId());
					tablaClientes.eliminar(tablaClientes.getUltimoClientePosicion());
					tablaClientes.repaint();
				}
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground(new Color(200,200,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground(new Color(255, 60, 60));
			}
		});
		
		
		//------------BTN EDITAR
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tablaEnPantalla == 0) {
					JFrameEditarReserva frameEditarReserva = new JFrameEditarReserva(tablaReservas);
					frameEditarReserva.setLocationRelativeTo(null);
					frameEditarReserva.setVisible(true);
				}else if(tablaEnPantalla == 1) {
					JFrameEditarCliente frameEditarCliente = new JFrameEditarCliente(tablaClientes);
					frameEditarCliente.setLocationRelativeTo(null);
					frameEditarCliente.setVisible(true);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEditar.setBackground(new Color(200,200,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEditar.setBackground(new Color(255, 113, 45));
			}
		});
		

	
	}
		

	private String construcDate(Date date) {
		String day = String.valueOf(date.getDate());
		String month = String.valueOf(date.getMonth());
		String year = String.valueOf(date.getYear() - 100);
		
		String checkDate = day + "/" + month + "/" + year;
		
		return checkDate;
		
	}
	
	private Color btnColor(JPanel tabla, Color color1, Color color2) {
		Color color;
		if(tabla.isVisible()) {
			color = color1;
		}else {
			color = color2;
		}
		return color;
	}
	
	private void invertColors(JLabel labe1, JPanel boton1, JLabel label2, JPanel boton2, Color color1, Color color2, JPanel tabla1, JPanel tabla2) {
		labe1.setForeground((btnColor(tabla1, lblWhite, lblBlack)));
		label2.setForeground((btnColor(tabla2, lblWhite, lblBlack)));
		boton2.setBackground(btnColor(tabla2, color1, color2));
		boton1.setBackground(btnColor(tabla1, color1, color2));
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
