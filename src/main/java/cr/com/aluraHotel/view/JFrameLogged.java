package cr.com.aluraHotel.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cr.com.aluraHotel.DAO.ReservasDAO;
import cr.com.aluraHotel.controller.DataUsuariosController;
import cr.com.aluraHotel.controller.IniciarSesionController;
import cr.com.aluraHotel.model.RoundBorder;
import cr.com.aluraHotel.model.Usuario;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;

public class JFrameLogged extends JFrame {

	private JPanel contentPane, upToolBar;
	private JLabel lblExitIcon;
	private JPanel btnExit;
	private JLabel lblLoginBackground;
	private JPanel panellLoginBackGround;
	private JLabel lblNewLabel;
	private JPanel btnReservas;
	private JLabel lblReservas;
	private JLabel lblReservasLogo;
	private JFrameLogin JFrameLogin;
	private JPanel btnLogout;
	private JLabel lblLogooutLogo;
	private JLabel lbLogout;
	private JLabel lblBusquedas;
	private JLabel lblLBusquedasLogo;
	private JPanel btnBusquedas;
	private JPanel panelBtnsContainer;
	
	private int mouseX, mouseY;
	
	private IniciarSesionController iniciarSesionController;

	/**
	 * Create the frame.
	 */
	public JFrameLogged() {
		iniciarSesionController = new IniciarSesionController();
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(700, 0, 34, 28);
		upToolBar.add(btnExit);
		
		lblExitIcon = new JLabel("X");
		btnExit.add(lblExitIcon);
		
		panellLoginBackGround = new JPanel();
		panellLoginBackGround.setBounds(0, 0, 438, 559);
		contentPane.add(panellLoginBackGround);
		panellLoginBackGround.setLayout(null);
		
		
		lblLoginBackground = new JLabel("");
		lblLoginBackground.setBounds(0, 0, 438, 559);
		panellLoginBackGround.add(lblLoginBackground);
		setIcon(lblLoginBackground, ".\\images\\backgrounds\\LoginBackground.png");
		
		lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(96, 175, 219));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 37));
		lblNewLabel.setBounds(483, 31, 224, 55);
		contentPane.add(lblNewLabel);
		
		panelBtnsContainer = new JPanel();
		panelBtnsContainer.setBackground(Color.WHITE);
		panelBtnsContainer.setBounds(448, 91, 276, 457);
		contentPane.add(panelBtnsContainer);
		panelBtnsContainer.setLayout(null);
		
		btnReservas = new JPanel();
		btnReservas.setBounds(88, 35, 105, 101);
		panelBtnsContainer.add(btnReservas);
		btnReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btnReservas.setLayout(null);
		
		lblReservasLogo = new JLabel("");
		lblReservasLogo.setBounds(18, 21, 69, 59);
		setIcon(lblReservasLogo, ".\\images\\logos\\ReservasLogo.png");
		btnReservas.add(lblReservasLogo);
		
		
		lblReservas = new JLabel("RESERVAS");
		lblReservas.setBounds(103, 10, 79, 14);
		panelBtnsContainer.add(lblReservas);
		lblReservas.setForeground(new Color(112, 184, 222));
		lblReservas.setFont(new Font("Roboto", Font.PLAIN, 15));
		
		btnBusquedas = new JPanel();
		btnBusquedas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBusquedas.setLayout(null);
		btnBusquedas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBusquedas.setBounds(88, 179, 105, 101);
		panelBtnsContainer.add(btnBusquedas);
		
		lblLBusquedasLogo = new JLabel("");
		lblLBusquedasLogo.setBounds(24, 24, 55, 51);
		btnBusquedas.add(lblLBusquedasLogo);
		setIcon(lblLBusquedasLogo, ".\\images\\logos\\SearchLogo.png");
		
		lblBusquedas = new JLabel("BUSQUEDAS");
		lblBusquedas.setForeground(new Color(112, 184, 222));
		lblBusquedas.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblBusquedas.setBounds(96, 154, 95, 14);
		panelBtnsContainer.add(lblBusquedas);
		
		btnLogout = new JPanel();
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setLayout(null);
		btnLogout.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogout.setBounds(88, 321, 105, 101);
		panelBtnsContainer.add(btnLogout);
		
		lblLogooutLogo = new JLabel("");
		lblLogooutLogo.setBounds(18, 21, 69, 59);
		setIcon(lblLogooutLogo, ".\\images\\logos\\OutLogo.png");
		btnLogout.add(lblLogooutLogo);
		
		lbLogout = new JLabel("LOGOUT");
		lbLogout.setForeground(new Color(112, 184, 222));
		lbLogout.setFont(new Font("Roboto", Font.PLAIN, 15));
		lbLogout.setBounds(110, 297, 65, 14);
		panelBtnsContainer.add(lbLogout);
		
		
		btnReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReservas.setBackground(new Color(200, 200 ,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReservas.setBackground(new Color(240, 240 ,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JFrameRegistrarReserva frameRegistrarReserva =  new JFrameRegistrarReserva();
				frameRegistrarReserva.setLocationRelativeTo(null);
				frameRegistrarReserva.setVisible(true);
				
			}
		});

		
		
		
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
		
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExitIcon.setForeground(new Color(255, 255, 255));
				btnExit.setBackground(new Color(200, 0 ,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExitIcon.setForeground(new Color(0, 0, 0));
				btnExit.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?") == 0) System.exit(0);
			}
		});
		
		
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(rootPane, "Seguro que quieres cerrar sesion?") == 0) {
					iniciarSesionController.cerrarSesionUser();
					setVisible(false);
					JFrameMain frameMain = new JFrameMain();
					frameMain.setLocationRelativeTo(null);
					frameMain.setVisible(true);
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogout.setBackground(new Color(200, 200 ,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogout.setBackground(new Color(240, 240 ,240));
			}
		});
		
		btnBusquedas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusquedas.setBackground(new Color(200, 200 ,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBusquedas.setBackground(new Color(240, 240 ,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
				JFrameBusqueda jFrameBusqueda = new JFrameBusqueda();
				jFrameBusqueda.setLocationRelativeTo(null);
				jFrameBusqueda.setVisible(true);
				
			}
		});
	}
}
