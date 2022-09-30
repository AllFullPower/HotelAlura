package cr.com.aluraHotel.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cr.com.aluraHotel.controller.NacionalidadNumeroController;
import cr.com.aluraHotel.model.RoundBorder;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

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

public class JFrameMain extends JFrame {

	private JPanel contentPane, upToolBar;
	private int mouseX, mouseY;
	private JLabel lblExitIcon;
	private JPanel btnExit;
	private JLabel lblLoginBackground;
	private JPanel panellLoginBackGround;
	private JLabel lblNewLabel;
	private JPanel btnLogin;
	private JLabel lblNewLabel_1;
	private JLabel lblLoginLogo;
	private JFrameLogin JFrameLogin;

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		
		NacionalidadNumeroController nacionalidadNumeroController = new NacionalidadNumeroController();
		nacionalidadNumeroController.leerArchivoMap();
	
		
		
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
		
		lblNewLabel = new JLabel("BIENVENIDO\r\n");
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(96, 175, 219));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 37));
		lblNewLabel.setBounds(483, 75, 224, 55);
		contentPane.add(lblNewLabel);
		
		btnLogin = new JPanel();
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.setBounds(541, 246, 105, 101);
		contentPane.add(btnLogin);
		btnLogin.setLayout(null);
		
		lblLoginLogo = new JLabel("");
		lblLoginLogo.setBounds(18, 21, 69, 59);
		btnLogin.add(lblLoginLogo);
		setIcon(lblLoginLogo, ".\\images\\logos\\LoginLogo.png");
		
		lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(112, 184, 222));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(570, 222, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		

		
		
		
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
		
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(200, 200 ,200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(240, 240 ,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JFrameLogin.setLocationRelativeTo(null);
				JFrameLogin.setVisible(true);
				
			}
		});
	}
}
