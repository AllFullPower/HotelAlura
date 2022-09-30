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

import cr.com.aluraHotel.DAO.ReservasDAO;
import cr.com.aluraHotel.controller.ReservasController;
import cr.com.aluraHotel.controller.ValidarInputsController;
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
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class JFrameRegistrarReserva extends JFrame {

	private JPanel contentPane, upToolBar;
	private JLabel lblExitIcon;
	private JPanel btnExit;
	private JLabel lblSistemaDeReservasBackground;
	private JPanel panellLoginBackGround;
	private JLabel lblNewLabel;
	private JFrameLogin JFrameLogin;
	private JPanel panelnputsContainer;
	private JDateChooser chooserCheckIn;
	private JLabel lblNewLabel_1;
	private JDateChooser chooserCheckOut;
	private JLabel lblNewLabel_1_1;
	private JTextArea textAreaMonto;
	private JLabel lblNewLabel_1_1_1;
	private JComboBox comboBoxMetodoDePago;
	private JLabel lblNewLabel_1_1_1_1;
	private JPanel btnNext;
	private JLabel lblBtnNext;
	
	private int mouseX, mouseY;
	
	private long precio = (long) 79.99;
	private JPanel btnBack;
	private JLabel lblBtnBackLogo;
	private ValidarInputsController inputsController;
	
	private JFrameRegistrarCliente frameRegistrarCliente;
	
	private ReservasDAO reservasDAO;
	
	
	
	private int nextClicked = 0;
	private String ultimaReservaId;
	private Integer ultimoElementoRegistrado;
	private JPanel panelBackgroundContainer;
	
	private List<JDateChooser> listaDateChoosers = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public JFrameRegistrarReserva() {
		setUndecorated(true);
		reservasDAO = new ReservasDAO();
		frameRegistrarCliente = new JFrameRegistrarCliente(this);
		inputsController = new ValidarInputsController();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
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
		panellLoginBackGround.setBounds(0, 0, 331, 559);
		contentPane.add(panellLoginBackGround);
		panellLoginBackGround.setLayout(null);
		
		btnBack = new JPanel();
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(0, 520, 42, 39);
		panellLoginBackGround.add(btnBack);
		btnBack.setLayout(null);
		
		lblBtnBackLogo = new JLabel("New label");
		lblBtnBackLogo.setBounds(8, 8, 26, 24);
		setIcon(lblBtnBackLogo, ".\\images\\logos\\OutLogo.png");
		btnBack.add(lblBtnBackLogo);
		

		
		lblNewLabel = new JLabel("Sistema de Reservas");
		lblNewLabel.setBounds(37, 39, 258, 55);
		panellLoginBackGround.add(lblNewLabel);
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(96, 175, 219));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 25));
		
		panelnputsContainer = new JPanel();
		panelnputsContainer.setOpaque(false);
		panelnputsContainer.setBorder(UIManager.getBorder("Button.border"));
		panelnputsContainer.setBackground(Color.WHITE);
		panelnputsContainer.setBounds(10, 84, 311, 454);
		panellLoginBackGround.add(panelnputsContainer);


		
		
		
		panelBackgroundContainer = new JPanel();
		panelBackgroundContainer.setOpaque(false);
		panelBackgroundContainer.setBackground(new Color(192, 192, 192));
		panelBackgroundContainer.setBounds(329, 0, 405, 559);
		contentPane.add(panelBackgroundContainer);
		panelBackgroundContainer.setLayout(null);
		
		
		
		lblSistemaDeReservasBackground = new JLabel("");
		lblSistemaDeReservasBackground.setOpaque(true);
		lblSistemaDeReservasBackground.setBounds(0, 0, 405, 559);
		panelBackgroundContainer.add(lblSistemaDeReservasBackground);
		setIcon(lblSistemaDeReservasBackground, ".\\images\\backgrounds\\SistemaDeReservasFechaBackground.png");
		panelnputsContainer.setLayout(null);
		
		chooserCheckIn = new JDateChooser();
		chooserCheckIn.setDateFormatString("MMM, d, y");
		chooserCheckIn.setBackground(Color.LIGHT_GRAY);
		chooserCheckIn.setBounds(42, 61, 227, 35);
		panelnputsContainer.add(chooserCheckIn);
		
		lblNewLabel_1 = new JLabel("Fecha de Check In:");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(42, 36, 174, 14);
		panelnputsContainer.add(lblNewLabel_1);
		
		chooserCheckOut = new JDateChooser();
		chooserCheckOut.setBackground(Color.LIGHT_GRAY);
		chooserCheckOut.setBounds(42, 158, 227, 35);
		panelnputsContainer.add(chooserCheckOut);
		
		lblNewLabel_1_1 = new JLabel("Fecha de Check Out:");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(42, 133, 174, 14);
		panelnputsContainer.add(lblNewLabel_1_1);
		
		textAreaMonto = new JTextArea();
		textAreaMonto.setEditable(false);
		textAreaMonto.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaMonto.setText("");
		textAreaMonto.setBackground(Color.LIGHT_GRAY);
		textAreaMonto.setBounds(42, 258, 227, 35);
		panelnputsContainer.add(textAreaMonto);
		
		lblNewLabel_1_1_1 = new JLabel("Monto:");
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(42, 231, 174, 14);
		panelnputsContainer.add(lblNewLabel_1_1_1);
		
		comboBoxMetodoDePago = new JComboBox();
		comboBoxMetodoDePago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Credito", "Tarjeta de Debito", "Efectivo", "SinpeMovil\t"}));
		comboBoxMetodoDePago.setBounds(42, 355, 227, 30);
		panelnputsContainer.add(comboBoxMetodoDePago);
		
		lblNewLabel_1_1_1_1 = new JLabel("Metodo de pago:");
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(42, 324, 174, 20);
		panelnputsContainer.add(lblNewLabel_1_1_1_1);
		
		btnNext = new JPanel();
		//244, 186, 51
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setBackground(new Color(244, 186, 51));
		btnNext.setBounds(215, 413, 86, 30);
		panelnputsContainer.add(btnNext);
		btnNext.setLayout(null);
		
		lblBtnNext = new JLabel("Next");
		lblBtnNext.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblBtnNext.setBounds(22, 8, 37, 14);
		btnNext.add(lblBtnNext);
		
		

		listaDateChoosers.add(chooserCheckIn);
		listaDateChoosers.add(chooserCheckOut);
		
		
		
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
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?") == 0) {
					if(nextClicked == 1) reservasDAO.elliminar(ReservasController.getUltimoElementoRegistradoId());
					System.exit(0);
				}
			}
		});
		
		//----------BOTON NEXT
		
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Contando los clicks en next
				if(!inputsController.validarDates(listaDateChoosers)) {
					JOptionPane.showMessageDialog(null, "No puedes dejar las fechas vacias");
				}else {
					nextClicked += 1;	
				}
				
				//Creando la reserva
				String dateCheckIn = construcDate(chooserCheckIn.getDate());
				String dateCheckOut = construcDate(chooserCheckOut.getDate());
				int days = (int) calcularDias();
				int monto = (int) Calcularmonto(calcularDias());
				String metodoDePago = String.valueOf(comboBoxMetodoDePago.getSelectedItem());
				
				//Validity of put or modify
				if(nextClicked == 1) {
					//Guardando la reserva
					Reserva reserva = new Reserva(dateCheckIn, dateCheckOut, days, monto, metodoDePago);
					reservasDAO.guardarReservas(reserva);
					System.out.println("Guardando Reserva...");
					
				}else {
					if(!inputsController.validarDates(listaDateChoosers)) return;
					reservasDAO.modificarReserva(ReservasController.getUltimoElementoRegistradoId(), dateCheckIn, dateCheckOut, days, monto, metodoDePago);
					System.out.println("Modificando su ultima reserva...");
				}
				
				frameRegistrarCliente.getTxtANumeroReserva().setText(String.valueOf(ReservasController.getUltimoElementoRegistradoId()));
				
				setVisible(false);
				frameRegistrarCliente.setLocationRelativeTo(null);
				frameRegistrarCliente.setVisible(true);
				
					
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnNext.setForeground(Color.WHITE);
				btnNext.setBackground(new Color(223, 160, 13));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBtnNext.setForeground(Color.BLACK);
				btnNext.setBackground(new Color(244, 186, 51));
			}
		});
		
		
		//----CALENDARIOS DETECTOR DE MONTOS
		
		
		//-----CALENDARIO 1 (CHECK IN)
		chooserCheckIn.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String textMonto = String.valueOf(Calcularmonto(calcularDias()));
				textAreaMonto.setText("$" + textMonto);
			}
		});
		
		//-------CALENDARIO 2 (CHECK OUT)
		chooserCheckOut.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String textMonto = String.valueOf(Calcularmonto(calcularDias()));
				textAreaMonto.setText("$" + textMonto);
			}
		});
		
		//-------------BOTON BACK
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres regresar al menu?") == 0) {
					if(nextClicked == 1) reservasDAO.elliminar(ReservasController.getUltimoElementoRegistradoId());
	
					setVisible(false);
					JFrameLogged frameLogged = new JFrameLogged();
					frameLogged.setLocationRelativeTo(null);
					frameLogged.setVisible(true);
				}
			}
		});

	}

	
	
	private String construcDate(Date date) {
		String day = String.valueOf(date.getDate());
		String month = String.valueOf(date.getMonth() + 1);
		System.out.println(date.getYear());
		String year = calcYear(date.getYear());
		
		String checkDate = day + "/" + month + "/" + year;
		
		return checkDate;
		
	}
	
	private String calcYear(int year) {
		String result = String.valueOf(year);
		if(year >= 110) {
			result = String.valueOf(year - 100); 
		}else if(year < 110 && year > 100) {
			result = "0" + String.valueOf(year-100);
		}else if(year == 100) {
			result = "2000";
		}
		return result;
	}
	
	public long Calcularmonto(long dias) {
		long resultado = 0;
		if(dias >= 1) {
			for(int i = 0; i <= dias; i++) {
				long operacion = precio * dias;
				resultado = operacion;
			}
		}
		return resultado;
	}
	
	public long calcularDias() {
		long resultado = 0;
		Date fechaIn = chooserCheckIn.getDate();
		Date fechaOut = chooserCheckOut.getDate();
		if(fechaIn != null && fechaOut != null) {
			long chronoUnit = ChronoUnit.DAYS.between(fechaIn.toInstant(),fechaOut.toInstant());
			resultado = chronoUnit;
		}
		return resultado;
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
