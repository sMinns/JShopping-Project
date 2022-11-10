package gui.common;

import gui.contents.main.Home;
import gui.menu.GuestMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;


	public class Frame extends JFrame {
		public static Frame frame;
		public static JPanel mainPanel = new JPanel();
		public static JLayeredPane contentLayeredPanel;
		public static JLayeredPane menuLayeredPanel;
		public static GridBagConstraints mainBagConstraints = new GridBagConstraints();
		public static GridBagLayout gbl_mainPanel = new GridBagLayout();
		private int x = Setup.screenSize.width / 2 - 600;
		private int y = Setup.screenSize.height / 2 - 375;
		
		public Frame() {
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(x, y, 1200, 750);
			mainPanel.setBackground(Setup.bgLightGray);
			setUndecorated(true);
			setContentPane(mainPanel);
			gbl_mainPanel.columnWidths = new int[]{218, 0, 0};
			gbl_mainPanel.rowHeights = new int[]{60, 40, 0, 0};
			gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			mainPanel.setLayout(gbl_mainPanel);
			
			
			contentLayeredPanel = new JLayeredPane();
			menuLayeredPanel = new JLayeredPane();
			
			//BarPanel
				mainBagConstraints = new GridBagConstraints();
				mainBagConstraints.gridwidth = 2;
				mainBagConstraints.fill = GridBagConstraints.BOTH;
				mainBagConstraints.gridx = 0;
				mainBagConstraints.gridy = 0;
				mainPanel.add(new BarPanel(), mainBagConstraints);
			
			//MenuPanel
				mainBagConstraints.gridy = 1;
				mainBagConstraints.gridwidth = 1;
				mainBagConstraints.gridheight = 2;
				mainPanel.add(menuLayeredPanel, mainBagConstraints);
				menuLayeredPanel.setLayout(new CardLayout());
				menuLayeredPanel.add(new GuestMenu());
			
			//ContentPanel
				mainBagConstraints.insets = new Insets(10, 10, 10, 10);
				mainBagConstraints.gridx = 1;
				mainPanel.add(contentLayeredPanel, mainBagConstraints);
				contentLayeredPanel.setLayout(new CardLayout());
				contentLayeredPanel.add(new Home());
		}
	}
