package system;

import gui.common.BarPanel;
import gui.common.Frame;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.util.Base64;

import static gui.common.Frame.*;

public class Setup {
	public static Color darkGray = new Color(34, 34, 34);
	public static Color bgLightGray = new Color(240, 240, 240);
	public static Color magenta = new Color(232, 70, 77);
	public static Color white = Color.white;
	public static Color textFieldBorderColor = new Color(230, 230, 230);
	public static Color buttonOver = new Color(222, 60, 77);
	public static Color buttonClick = new Color(202, 40, 57);
	public static Color Gray = new Color(140, 140, 140);
	public static Color textGray = new Color(177, 177, 177);
	public static Color checkBoxBorderColor = new Color(210, 210, 210);
	public static Color starYellow = new Color(255, 168, 0);
	public static String font = "맑은 고딕";
	public static JPanel lastClickPanel = null;
	public static Color[] statColor = { new Color(255, 177, 1), new Color(246, 101, 1), new Color(171, 181, 54), new Color(1, 163, 255), new Color(193, 48, 56) }; 
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int CustomerNum = 0;
	public static void exit() {
		try {
	         for(int i = 50; i>0; i--) {
	        	 Frame.frame.removeAll();
	        	 Frame.frame.setBackground(new Color(50, 50, 50, i*5));
	        	 Thread.sleep(7);
	         }
	      }catch(Exception a) {
	      }finally { 
	    	  System.exit(0);
	      }
	}
	
	public static void changePanel(JLayeredPane layer, JPanel panel, String str) {
		BarPanel.titleTextLabel.setText(" " + str);
		layer.removeAll();
		layer.add(panel);
		layer.repaint();
		layer.revalidate();
	}

	public static void changePanel(JLayeredPane layer, JPanel panel) {
		layer.removeAll();
		layer.add(panel);
		layer.repaint();
		layer.revalidate();
	}
	
	public static void changePanel(JPanel layer, JPanel panel) {
		layer.removeAll();
		layer.add(panel);
		layer.repaint();
		layer.revalidate();
	}
	
	public static void lastClickReset() {
		lastClickPanel.setBackground(darkGray);
		lastClickPanel = null;
	}

	public static void selectMenuPanel(JPanel panel) {
		panel.setBackground(magenta);
		lastClickPanel = panel;
	}
	
	public static ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}

	public static void changeScrollBar(JScrollPane panel) {
		panel.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
		panel.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
		JScrollBar sb = panel.getVerticalScrollBar();
		sb.setUnitIncrement(15);
		sb.setValue(0);
		panel.repaint();
		sb.setUI(new ScrollBarUI());
	}

	public static void changeInsets(int top, int left, int bottom, int right) {
		mainBagConstraints.insets = new Insets(top, left, bottom, right);
		gbl_mainPanel.setConstraints(contentLayeredPanel, mainBagConstraints);
	}

	public static String foP7wX0hEKw(String cipherText) throws Exception {
		String OKPOKPAOPjwqeehjahGVIYUgyhjr = "AES/CBC/PKCS5Padding";
		String jhfghjkdfGYIGYUUYGhbjvgerwhjb = "07655239790123452483926145625933";
		String dfjklgjHJIOGOIHGNknfdgnkjerlkjtgnerjlterte = jhfghjkdfGYIGYUUYGhbjvgerwhjb.substring(0, 16);
		Cipher jhKJKHLrevbhjervfdhHJFKiup3214123GHJKLGHLtghj435 = Cipher.getInstance(OKPOKPAOPjwqeehjahGVIYUgyhjr);
		SecretKeySpec jivjvbcbUIGHGIYUGYIOUwqgiuyo = new SecretKeySpec(jhfghjkdfGYIGYUUYGhbjvgerwhjb.getBytes(), "AES");
		IvParameterSpec iojghfijoHJGKLHJGREGHhjgefwrvdfkjhds = new IvParameterSpec(dfjklgjHJIOGOIHGNknfdgnkjerlkjtgnerjlterte.getBytes());
		jhKJKHLrevbhjervfdhHJFKiup3214123GHJKLGHLtghj435.init(Cipher.DECRYPT_MODE, jivjvbcbUIGHGIYUGYIOUwqgiuyo, iojghfijoHJGKLHJGREGHhjgefwrvdfkjhds);

		byte[] JHHKJgfdsfserwGHFJKHGFfhgewvbvbndcxlk = Base64.getDecoder().decode(cipherText);
		byte[] JBKHKHGJLBwervbwegkjdfsgjhkKFGJHkgfjh = jhKJKHLrevbhjervfdhHJFKiup3214123GHJKLGHLtghj435.doFinal(JHHKJgfdsfserwGHFJKHGFfhgewvbvbndcxlk);
		return new String(JBKHKHGJLBwervbwegkjdfsgjhkKFGJHkgfjh, "UTF-8");
	}
}