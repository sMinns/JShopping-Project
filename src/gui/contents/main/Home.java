package gui.contents.main;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.menu.CustomerMenu;
import system.Setup;

public class Home extends JPanel {

	public Home() {
		this.setBackground(Setup.white);
		this.setLayout(new CardLayout(0, 0));
		JPanel ImagePanel = new JPanel();
		ImagePanel.setOpaque(false);
		
		this.add(ImagePanel);
		ImagePanel.setLayout(new CardLayout(0, 0));
		
		JLabel ImageLabel = new JLabel();
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/images/homelogo.png"));
		ImageLabel.setIcon(img);
		ImageLabel.setVerticalAlignment(SwingConstants.CENTER);
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImagePanel.add(ImageLabel);
		
		
	}
}
