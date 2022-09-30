package cr.com.aluraHotel.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cr.com.aluraHotel.controller.DataUsuariosController;
import cr.com.aluraHotel.controller.IniciarSesionController;
import cr.com.aluraHotel.controller.ValidarInputsController;
import cr.com.aluraHotel.model.RoundBorder;
import cr.com.aluraHotel.model.Usuario;
import cr.com.aluraHotel.windows.JFrameErrorWindow;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
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
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class JFrameLogin extends JFrame {

	private JPanel contentPane, upToolBar;
	private JLabel lblExitIcon;
	private JPanel btnExit;
	private JLabel lblLoginBackground;
	private JPanel panellLoginBackGround;
	private JLabel lblNewLabel;
	private JFormattedTextField inputUsuario;
	private JPanel btnIngresar;
	private JLabel lblNewLabel_2;
	private JLabel lblOutIcon;
	private JPanel btnGoBack;
	private JSeparator separatorContrasena;
	private JPasswordField frmtdtxtfldIngreseSuContrasena;
	private JLabel lblInputTextUnselectedUser;
	private JLabel lblInputTextUnselectedPassword;
	private JSeparator separatorUsuario;
	private JLabel lblNewLabel_1;
	
	private int mouseX, mouseY;
	
	private IniciarSesionController iniciarSesionController;
	private DataUsuariosController dataUsuariosController;
	private ValidarInputsController validarInputsController;
	private JFrame estaVentana;
	
	
	private List<JTextField> inputs = new ArrayList<JTextField>();

	/**
	 * Create the frame.
	 */
	public JFrameLogin() {
		iniciarSesionController =  new IniciarSesionController();
		dataUsuariosController = new DataUsuariosController();
		validarInputsController = new ValidarInputsController();
		dataUsuariosController.agregarUsuario(new Usuario("Jeff", "132"));
		dataUsuariosController.agregarUsuario(new Usuario("Jeff", "88"));
		dataUsuariosController.agregarUsuario(new Usuario("Jeff", "7"));
		dataUsuariosController.agregarUsuario(new Usuario("Jeff", "1"));
		dataUsuariosController.agregarUsuario(new Usuario("Carlos", "132"));
		dataUsuariosController.agregarUsuario(new Usuario("Marlene", "132"));
		dataUsuariosController.agregarUsuario(new Usuario("MarivelBrenes", "132"));
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//Contruir Escena
		constructorEscena();
		
		//Cargar el login
		
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
		upToolBar.setBounds(0, 0, 528, 28);
		contentPane.add(upToolBar);
		upToolBar.setLayout(null);
		
		btnExit = new JPanel();
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(494, 0, 34, 28);
		upToolBar.add(btnExit);
		
		lblExitIcon = new JLabel("X");
		btnExit.add(lblExitIcon);
		
		panellLoginBackGround = new JPanel();
		panellLoginBackGround.setBounds(0, 0, 279, 559);
		contentPane.add(panellLoginBackGround);
		panellLoginBackGround.setLayout(null);
		
		
		lblLoginBackground = new JLabel("");
		lblLoginBackground.setBounds(0, 0, 279, 559);
		panellLoginBackGround.add(lblLoginBackground);
		setIcon(lblLoginBackground, ".\\images\\backgrounds\\LoginStateBackground.png");
		
		lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(96, 175, 219));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 37));
		lblNewLabel.setBounds(350, 77, 117, 55);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(289, 155, 226, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		inputUsuario = new JFormattedTextField();
		inputUsuario.setBackground(new Color(64, 0, 64));
		inputUsuario.setToolTipText("");
		inputUsuario.setName("UserInput");
		inputUsuario.setSelectionColor(new Color(183, 222, 255));
		inputUsuario.setForeground(Color.DARK_GRAY);
		String textUser = "Ingrese su nombre de Usuario";
		inputUsuario.setBorder(null);
		inputUsuario.setOpaque(false);
		inputUsuario.setBounds(10, 63, 206, 31);
		inputs.add(inputUsuario);
		panel.add(inputUsuario);
		
		
		lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 34, 65, 18);
		panel.add(lblNewLabel_1);
		
		separatorUsuario = new JSeparator();
		separatorUsuario.setBackground(Color.BLACK);
		separatorUsuario.setBounds(10, 92, 206, 2);
		panel.add(separatorUsuario);
		
		frmtdtxtfldIngreseSuContrasena = new JPasswordField();
		frmtdtxtfldIngreseSuContrasena.setName("PasswordInput");
		frmtdtxtfldIngreseSuContrasena.setOpaque(false);
		frmtdtxtfldIngreseSuContrasena.setForeground(Color.DARK_GRAY);
		frmtdtxtfldIngreseSuContrasena.setBorder(null);
		frmtdtxtfldIngreseSuContrasena.setBounds(10, 173, 206, 31);
		inputs.add(frmtdtxtfldIngreseSuContrasena);
		panel.add(frmtdtxtfldIngreseSuContrasena);
		
		final JLabel lblNewLabel_1_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 106, 18);
		panel.add(lblNewLabel_1_1);
		
		separatorContrasena = new JSeparator();
		separatorContrasena.setBackground(Color.BLACK);
		separatorContrasena.setBounds(10, 202, 206, 2);
		panel.add(separatorContrasena);
		
		btnIngresar = new JPanel();
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setBackground(new Color(72, 180, 238));
		btnIngresar.setForeground(new Color(72, 180, 238));
		btnIngresar.setBounds(33, 243, 156, 35);
		panel.add(btnIngresar);
		btnIngresar.setLayout(null);
		
		lblNewLabel_2 = new JLabel("INGRESAR");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2.setBounds(45, 11, 101, 14);
		btnIngresar.add(lblNewLabel_2);
		
		lblInputTextUnselectedUser = new JLabel("Ingrese su nombre de Usuario");
		lblInputTextUnselectedUser.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblInputTextUnselectedUser.setForeground(Color.LIGHT_GRAY);
		lblInputTextUnselectedUser.setBounds(10, 71, 206, 14);
		panel.add(lblInputTextUnselectedUser);
		
		lblInputTextUnselectedPassword = new JLabel("Ingrese su Contrasena");
		lblInputTextUnselectedPassword.setForeground(Color.LIGHT_GRAY);
		lblInputTextUnselectedPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblInputTextUnselectedPassword.setBounds(10, 181, 206, 14);
		panel.add(lblInputTextUnselectedPassword);
		
		btnGoBack = new JPanel();
		btnGoBack.setBackground(Color.WHITE);
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.setBounds(492, 523, 36, 36);
		contentPane.add(btnGoBack);
		btnGoBack.setLayout(null);
		
		lblOutIcon = new JLabel("New label");
		lblOutIcon.setBounds(6, 6, 25, 26);
		setIcon(lblOutIcon, ".\\images\\logos\\OutLogo.png");
		btnGoBack.add(lblOutIcon);
		
		
		estaVentana = this;

		
		
		
		//-----------------------EVETNS LISTENERS
		
		//Mover la ventana de lugar 
		
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
		
		//BTN EXIT
		
		
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
		
		//BTN REGRESAR
		
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGoBack.setBackground(new Color(240, 240 ,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGoBack.setBackground(new Color(250, 250 ,250));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JFrameMain framelMain = new JFrameMain();
				framelMain.setLocationRelativeTo(null);
				framelMain.setVisible(true);
				
			}
		});
		
		//Btn ingresar
		
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setBackground(new Color(0, 100, 238));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setBackground(new Color(72, 180, 238));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!validarInputsController.validarInputs(inputs)) {
					JOptionPane.showMessageDialog(null, "No puedes dejar espacios en blanco");
					/*JFrameErrorWindow errorWindow = new JFrameErrorWindow(estaVentana ,"No dejes los campos vacios");
					errorWindow.setLocationRelativeTo(null);
					errorWindow.setVisible(true);*/
				
				}else {	
					String userName =  String.valueOf(inputUsuario.getText());
					String contrasena = String.valueOf(frmtdtxtfldIngreseSuContrasena.getPassword());
					if(iniciarSesionController.validarUsuario(userName, contrasena)) {
						setVisible(false);
						JFrameLogged sessionLogged = new JFrameLogged();
						sessionLogged.setLocationRelativeTo(null);
						sessionLogged.setVisible(true);
					}
				}
			}
		});
		
		//Input Nombre de Usuario
		
		inputUsuario.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				lblInputTextUnselectedUser.setVisible(false);
				separatorUsuario.setBackground(Color.CYAN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				separatorUsuario.setBackground(Color.BLACK);
				boolean noEscribio = inputUsuario.getText().isEmpty();
				if(noEscribio) {
					lblInputTextUnselectedUser.setVisible(true);
				}
	
			}
		});
		
		//Input Contrasena
		
		frmtdtxtfldIngreseSuContrasena.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				separatorContrasena.setBackground(Color.CYAN);
				lblInputTextUnselectedPassword.setVisible(false);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				separatorContrasena.setBackground(Color.BLACK);
				boolean noEscribio = frmtdtxtfldIngreseSuContrasena.getText().isEmpty();
				if(noEscribio) {
					lblInputTextUnselectedPassword.setVisible(true);
				}
			}
		});
		
		
		
	}
}
