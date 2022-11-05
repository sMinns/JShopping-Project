package gui.menu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import system.Setup;

public class MenuButton extends JPanel {
	public MenuButton(ImageIcon img, String str) {
		this.setBackground(new Color(34, 34, 34));
		
		GridBagLayout MenuBagLayout = new GridBagLayout();
		MenuBagLayout.columnWidths = new int[]{50, 0, 0};
		MenuBagLayout.rowHeights = new int[]{0, 0};
		MenuBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		MenuBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.setLayout(MenuBagLayout);
	
		JPanel ImagePanel = new JPanel();
		ImagePanel.setOpaque(false);
		GridBagConstraints MenuBagConstraints = new GridBagConstraints();
		MenuBagConstraints.insets = new Insets(0, 0, 0, 1);
		MenuBagConstraints.fill = GridBagConstraints.BOTH;
		MenuBagConstraints.gridx = 0;
		MenuBagConstraints.gridy = 0;
		
		this.add(ImagePanel, MenuBagConstraints);
		ImagePanel.setLayout(new CardLayout(0, 0));
		
		JLabel ImageLabel = new JLabel();
		ImageLabel.setIcon(img);
		ImageLabel.setVerticalAlignment(SwingConstants.CENTER);
		ImageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ImagePanel.add(ImageLabel);
		
		JPanel TextPanel = new JPanel();
		TextPanel.setOpaque(false);
		GridBagConstraints TextBagConstraints = new GridBagConstraints();
		TextBagConstraints.insets = new Insets(0, 20, 0, 0);
		TextBagConstraints.fill = GridBagConstraints.BOTH;
		TextBagConstraints.gridx = 1;
		TextBagConstraints.gridy = 0;
		this.add(TextPanel, TextBagConstraints);
		TextPanel.setLayout(new CardLayout(0, 0));
		
		JLabel TextLabel = new JLabel(str);
		TextLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TextLabel.setFont(new Font(Setup.font, Font.BOLD, 18));
		TextLabel.setForeground(Setup.bgLightGray);
		TextPanel.add(TextLabel);
	}
}
