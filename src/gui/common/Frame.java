package gui.common;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import gui.main.HomePanel;
import gui.menu.GuestPanel;
import system.Setup;


	public class Frame extends JFrame {
		public static Frame frame;
		public static JPanel mainPanel = new JPanel();
		public static JPanel menuPanel = new JPanel();
		public static JLayeredPane contentPanel;
		public Frame() {
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1200, 750);
			mainPanel.setBackground(Setup.bgLightGray);
			setUndecorated(true);

			setContentPane(mainPanel);
			GridBagLayout gbl_mainPanel = new GridBagLayout();
			gbl_mainPanel.columnWidths = new int[]{215, 0, 0};
			gbl_mainPanel.rowHeights = new int[]{60, 40, 0, 0};
			gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			mainPanel.setLayout(gbl_mainPanel);
			
			
			contentPanel = new JLayeredPane();
			
			//BarPanel
				GridBagConstraints mainBagConstraints = new GridBagConstraints();
				mainBagConstraints.gridwidth = 2;
				mainBagConstraints.fill = GridBagConstraints.BOTH;
				mainBagConstraints.gridx = 0;
				mainBagConstraints.gridy = 0;
				mainPanel.add(new BarPanel(), mainBagConstraints);
			
			//MenuPanel
			mainBagConstraints.gridy = 1;
			mainBagConstraints.gridwidth = 1;
			mainBagConstraints.gridheight = 2;
			mainPanel.add(new GuestPanel(), mainBagConstraints);
			
			mainPanel.add(contentPanel);
			
			//ContentPanel
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 2;
			gbc_panel.insets = new Insets(10, 10, 10, 10);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			mainPanel.add(contentPanel, gbc_panel);
			
			contentPanel.setLayout(new CardLayout());
			contentPanel.add(new HomePanel());
			
			
		}
	}
