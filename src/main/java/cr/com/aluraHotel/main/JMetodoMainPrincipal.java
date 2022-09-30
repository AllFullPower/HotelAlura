package cr.com.aluraHotel.main;

import javax.swing.JFrame;

import cr.com.aluraHotel.view.JFrameMain;

public class JMetodoMainPrincipal {
	public static void main(String[] args) {
		try {
			JFrameMain frame = new JFrameMain();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
