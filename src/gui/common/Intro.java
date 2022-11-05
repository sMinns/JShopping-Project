package gui.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import system.Setup;

public class Intro extends JFrame {
	
	public Intro() {
		int x = (Setup.screenSize.width / 2) - 245;
		int y = (Setup.screenSize.height / 2) - 75;
		setBounds(x, y	, 490, 150);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0 ,0));
		
		JLabel label = new JLabel();
		label.setOpaque(false);
        label.setIcon(new ImageIcon(Frame.class.getResource("/images/intro.png")));
        this.add(label);
        this.setVisible(true);
	}
}
