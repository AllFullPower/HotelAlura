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

import cr.com.aluraHotel.DAO.ReservasDAO;
import cr.com.aluraHotel.JPanels.TablaReservas;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.controller.UltimoElementoSelecionadoController;
import cr.com.aluraHotel.model.Cliente;
import cr.com.aluraHotel.model.Reserva;
import cr.com.aluraHotel.model.RoundBorder;
import cr.com.aluraHotel.view.JFrameLogged;
import cr.com.aluraHotel.view.JFrameLogin;
import cr.com.aluraHotel.view.JFrameRegistrarCliente;

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
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;

public class JFrameErrorWindow extends JFrame {

	private JPanel contentPane, upToolBar;
	private JPanel btnExit;
	private JFrameLogin JFrameLogin;
	
	private int mouseX, mouseY;
	
	private long precio = (long) 79.99;
	
	
	private JFrameRegistrarCliente frameRegistrarCliente;
	
	private ReservasDAO reservasDAO;
	
	private int nextClicked = 0;
	private Integer ultimaReservaId;
	private TablaReservas tablaReservas;
	
	private boolean respuesta = false;
	private JLabel lblSystemError;
	private JPanel btnAceptar;
	private JLabel lblBtnAceptar;
	private JPanel btnCancelar;
	private JLabel lblBtnCancelar;
	private JPanel panelContenedorMenssage;
	private JLabel lblMensajeError;
	private JLabel lblExitIcon;
	private JLabel iconoAlura;
	/**
	 * Create the frame.
	 */
	public JFrameErrorWindow(JFrame estaVentana,String menssage) {
		setUndecorated(true);
		reservasDAO = new ReservasDAO();
		this.tablaReservas = tablaReservas;
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//Contruir Escena
		constructorEscena(estaVentana, menssage);
		
		//Cargar el login
		JFrameLogin = new JFrameLogin();
	}
	

	public void setIcon(JLabel label, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
	}
	public void constructorEscena(JFrame estaVentana, String message) {
		
		upToolBar = new JPanel();
		upToolBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		upToolBar.setBackground(Color.DARK_GRAY);
		upToolBar.setBounds(0, 0, 523, 28);
		contentPane.add(upToolBar);
		upToolBar.setLayout(null);
		
		btnExit = new JPanel();
		btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(488, 0, 34, 28);
		upToolBar.add(btnExit);
		btnExit.setLayout(null);
		
		lblExitIcon = new JLabel("X");
		lblExitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitIcon.setBounds(6, 1, 24, 25);
		btnExit.add(lblExitIcon);
		
		lblSystemError = new JLabel("System ERROR ");
		lblSystemError.setFont(new Font("Roboto", Font.PLAIN, 52));
		lblSystemError.setForeground(new Color(11, 164, 196));
		lblSystemError.setBounds(85, 39, 362, 84);
		contentPane.add(lblSystemError);
		
		btnAceptar = new JPanel();

		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBackground(new Color(11, 164, 196));
		btnAceptar.setBounds(54, 293, 124, 28);
		contentPane.add(btnAceptar);
		btnAceptar.setLayout(null);
		
		lblBtnAceptar = new JLabel("Aceptar");
		lblBtnAceptar.setForeground(new Color(255, 255, 255));
		lblBtnAceptar.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblBtnAceptar.setBounds(33, 4, 69, 20);
		btnAceptar.add(lblBtnAceptar);
		
		btnCancelar = new JPanel();
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBackground(new Color(11, 164, 196));
		btnCancelar.setBounds(342, 293, 124, 28);
		contentPane.add(btnCancelar);
		btnCancelar.setLayout(null);
		
		lblBtnCancelar = new JLabel("Cancelar");
		lblBtnCancelar.setForeground(new Color(255, 255, 255));
		lblBtnCancelar.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblBtnCancelar.setBounds(29, 4, 69, 20);
		btnCancelar.add(lblBtnCancelar);
		
		panelContenedorMenssage = new JPanel();
		panelContenedorMenssage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelContenedorMenssage.setBackground(Color.DARK_GRAY);
		panelContenedorMenssage.setBounds(76, 164, 371, 76);
		contentPane.add(panelContenedorMenssage);
		panelContenedorMenssage.setLayout(null);
		
		lblMensajeError = new JLabel("Mensaje de error");
		lblMensajeError.setForeground(new Color(255, 255, 255));
		lblMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeError.setFont(new Font("Arial", Font.ITALIC, 20));
		lblMensajeError.setBounds(12, 22, 345, 32);
		lblMensajeError.setText(message);
		panelContenedorMenssage.add(lblMensajeError);
		
		iconoAlura = new JLabel("New label");
		iconoAlura.setBounds(213, 251, 97, 97);
		contentPane.add(iconoAlura);
		setIcon(iconoAlura, ".\\images\\logos\\HotelLogo.png");
		

		estaVentana.disable();
		
		
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
				btnExit.setBackground(new Color(211,0,0));
				lblExitIcon.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(Color.DARK_GRAY);
				lblExitIcon.setForeground(new Color(0, 0, 0));

			
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				estaVentana.enable();
				dispose();
			}
		});
		
		
		//---------BTN ACEPTAR
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAceptar.setBackground(new Color(108, 227, 227));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAceptar.setBackground(new Color(11, 164, 196));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				estaVentana.enable();
				respuesta = true;
				dispose();
			}
		});
		
		//----BTN CANCELAR
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setBackground(new Color(108, 227, 227));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setBackground(new Color(11, 164, 196));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				estaVentana.enable();
				respuesta = false;
				dispose();
			}
		});
	}
	
	public boolean getRespuesta() {
		return this.respuesta;
	}
}
