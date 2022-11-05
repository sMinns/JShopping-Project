package custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import system.Setup;

public class ButtonType1 extends JButton implements MouseListener {
	private Color buttonColor = Setup.magenta;
	private boolean over = false;
	public ButtonType1(int size, String text) {
		this.setContentAreaFilled(false);
		this.setFont(new Font(Setup.font, Font.BOLD, 16));
		this.setBorder(new EmptyBorder(10, size, 10, size));
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.addMouseListener(this);
		this.setForeground(Setup.white);
		this.setText(text);
	}
	
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g2.setColor(buttonColor);
		g2.fillRoundRect(0, 2, width-3, height-3, 10, 10);
		super.paintComponent(g);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		buttonColor = Setup.buttonOver;
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		buttonColor = Setup.buttonClick;
		repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(over) {
			buttonColor = Setup.buttonOver;
			repaint();
		}else {
			buttonColor = Setup.magenta;
			repaint();
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		buttonColor = Setup.magenta;
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) {}
}
