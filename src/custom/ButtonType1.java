package custom;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import system.Setup;

public class ButtonType1 extends JButton implements MouseListener {
	private Color buttonColor = Setup.magenta;
	private boolean over = false;
	private int round;
	public ButtonType1(int width, int height, int round, String text, int fontSize) {
		this.round = round;
		this.setContentAreaFilled(false);
		this.setFont(new Font(Setup.font, Font.BOLD, fontSize));
		this.setBorder(new EmptyBorder(height, width, height+4, width));
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
		g2.fillRoundRect(2, 0, width-3, height-3, round, round);
		super.paintComponent(g);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		buttonColor = Setup.buttonOver;
		setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		buttonColor = Setup.magenta;
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) {}
}
