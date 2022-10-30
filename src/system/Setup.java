package system;

import java.awt.Color;

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
	public static String font = "¸¼Àº °íµñ";
	
	
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
	
	public static void changePanel(JPanel panel, String str) {
		BarPanel.titleTextLabel.setText(str);
		gui.common.Frame.contentPanel.removeAll();
		Frame.contentPanel.add(panel);
		Frame.contentPanel.repaint();
		Frame.contentPanel.revalidate();
	}
}
