package system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import gui.common.BarPanel;
import gui.common.Frame;

public class Setup {
	public static Color darkGray = new Color(34, 34, 34);
	public static Color bgLightGray = new Color(240, 240, 240);
	public static Color magenta = new Color(232, 70, 77);
	public static Color white = Color.white;
	public static Color textFieldBorderColor = new Color(230, 230, 230);
	public static Color buttonOver = new Color(222, 60, 77);
	public static Color buttonClick = new Color(202, 40, 57);
	public static Color Gray = new Color(140, 140, 140);
	public static String font = "맑은 고딕";
	public static JPanel lastClickPanel = null;
	public static Color[] statColor = { new Color(255, 177, 1), new Color(246, 101, 1), new Color(171, 181, 54), new Color(1, 163, 255), new Color(193, 48, 56) }; 
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
	
	public static void changePanel(JPanel layer, JPanel panel) {
		layer.removeAll();
		layer.add(panel);
	}
	
	public static void lastClickReset() {
		lastClickPanel.setBackground(darkGray);
		lastClickPanel = null;
	}
	
	public static ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon�� Image�� ��ȯ.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
}
